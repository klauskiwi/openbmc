HOMEPAGE =  "https://github.ibm.com/phal/pdata/"

SUMMARY     = "POWER Host data management"
DESCRIPTION = "Device tree based POWER host data management"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

S = "${WORKDIR}/git"

inherit autotools \
        perlnative \
        mrw-xml

SRC_URI = "git://git@github.ibm.com/phal/pdata;protocol=ssh"
SRCREV = "68cbe66c904ffc6a72b5a6d791b96a6d23a20b99"

DEPENDS = "pdbg \
           libxml-simple-perl-native \
           libxml-libxml-perl-native \
           mrw-native \
           ekb-native \
           autoconf-archive"

BBCLASSEXTEND = "native"

EXTRA_OECONF = "--enable-gen_attrsinfo CHIP=${TARGET_PROC}"
EXTRA_OEMAKE = "SYSTEM_NAME=${MACHINE} \
                TARGET_PROC=${TARGET_PROC} \
                SYSTEM_MRW_XML=${STAGING_DIR_NATIVE}${mrw_datadir}/${MRW_XML} \
                EKB=${STAGING_DATADIR_NATIVE}/ekb/"
