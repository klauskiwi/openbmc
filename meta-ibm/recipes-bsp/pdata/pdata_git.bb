HOMEPAGE =  "https://github.ibm.com/phal/pdata/"

SUMMARY     = "POWER Host data management"
DESCRIPTION = "Device tree based POWER host data management"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

S = "${WORKDIR}/git"

inherit autotools \
        perlnative

SRC_URI = "git://git@github.ibm.com/phal/pdata;protocol=ssh"
SRCREV = "c0a8ca1e8047cb178c797bf744580225e3fe4c3d"

DEPENDS = "pdbg \
           libxml-simple-perl-native \
           libxml-libxml-perl-native \
           ekb-native \
           autoconf-archive"

BBCLASSEXTEND = "native"

PDATA_CONFARG = ""
PDATA_CONFARG_ibm-power9-cpu = "CHIP=p9"
PDATA_CONFARG_ibm-power10-cpu = "CHIP=p10"
EXTRA_OECONF = "--enable-gen_attrsinfo ${PDATA_CONFARG}"

EXTRA_OEMAKE = "EKB=${STAGING_DATADIR_NATIVE}/ekb/"
