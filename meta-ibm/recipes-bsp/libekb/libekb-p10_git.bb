HOMEPAGE =  "https://github.ibm.com/phal/libekb_p10/"

SUMMARY     = "Hardware Procedure Framework"
DESCRIPTION = "Provides infrastructure to run hardware procedures"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

S = "${WORKDIR}/git"

inherit autotools \
        pythonnative \
        perlnative

SRCREV_FORMAT = "libekb_ekb"

SRCREV_libekb = "c303ff00cf6050b7e69d818a05aa8e33d7754671"
SRCREV_ekb = "9ed077356c168629776a007dd422d8d35100ca9e"

EKB_BRANCH = "master-p10"
SRC_URI = "git://git@github.ibm.com/phal/libekb_p10;destsuffix=git/.libekb;name=libekb;protocol=ssh;bareclone=1 \
           git://git@github.ibm.com/openbmc/ekb;destsuffix=git/.ekb;name=ekb;branch=${EKB_BRANCH};protocol=ssh;bareclone=1 \
           file://fapi-attributes-xml.patch \
           file://ekb_SegFault_Fix.patch \
           file://ekb_Add_missing_include_file_required_for_memcpy.patch \
           file://0001-p10_do_fw_hb_istep-Fix-ICE-on-modern-g.patch \
           "

DEPENDS = "pdbg pdata libxml-simple-perl-native"

BBCLASSEXTEND = "native"

flatten_repository_tree () {
    # Flatten the git repos into one directory
    GIT_DIR=${S}/.libekb git archive --format=tar HEAD | (mkdir -p ${S} && cd ${S} && tar xf -)
    GIT_DIR=${S}/.ekb git archive --format=tar ${EKB_BRANCH} | (mkdir -p ${S}/ekb && cd ${S}/ekb && tar xf -)

    # Make the directory a git repo so do_patch() carries on
    cd ${S}
    GIT_OPTS="-c user.name=OpenEmbedded -c user.email=oe.patch@oe"
    git ${GIT_OPTS} init
    git ${GIT_OPTS} add .
    git ${GIT_OPTS} commit -m "Import"
    cd -
}

do_unpack_append() {
    bb.build.exec_func('flatten_repository_tree', d)
}
