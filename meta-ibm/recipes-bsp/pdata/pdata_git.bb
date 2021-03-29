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
SRCREV = "0e1a8181aa10d0c0ccb4659a0c588241808a192c"

DEPENDS = "pdbg \
           libxml-simple-perl-native \
           libxml-libxml-perl-native \
           mrw-native \
           ekb-native"

FILES_${PN} += "${datadir}"

BBCLASSEXTEND = "native"

# Make sure c++11 is used for native and nativesdk build
# Because, pdata using c++11 features
BUILD_CXXFLAGS += "-std=c++11"
BUILDSDK_CXXFLAGS += "-std=c++11"

EXTRA_OECONF = "--enable-gen_attrsinfoheader"
EXTRA_OEMAKE = "SYSTEM_NAME=${MACHINE} \
                TARGET_PROC=${TARGET_PROC} \
                SYSTEM_MRW_XML=${STAGING_DIR_NATIVE}${mrw_datadir}/${MRW_XML} \
                EKB=${STAGING_DATADIR_NATIVE}/ekb/"
