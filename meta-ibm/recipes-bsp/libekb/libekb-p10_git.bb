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

SRCREV_libekb = "7f4799cb677fc23abe6808efb1a94c159251a0ca"
SRCREV_ekb = "43250bb3fbeb46a97e254c6d03e0b8be8f69c340"

SRC_URI = "git://git@github.ibm.com/phal/libekb_p10;name=libekb;protocol=ssh \
            git://git@github.ibm.com/openbmc/ekb;destsuffix=git/ekb;name=ekb;branch=master-p10;protocol=ssh"

SRC_URI += "file://enable-istep0-procedures-only-p10.patch"
SRC_URI += "file://fapi-attributes-xml.patch"
SRC_URI += "file://ekb_SegFault_Fix.patch"
SRC_URI += "file://ekb_Add_missing_include_file_required_for_memcpy.patch"

DEPENDS = "pdbg pdata libxml-simple-perl-native"

BBCLASSEXTEND = "native"
