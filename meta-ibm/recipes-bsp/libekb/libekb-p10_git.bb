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

SRCREV_libekb = "c8fb4ec13bef4c78d4761a03609a4d0306ff7b1a"
SRCREV_ekb = "9ed077356c168629776a007dd422d8d35100ca9e"

SRC_URI = "git://git@github.ibm.com/phal/libekb_p10;name=libekb;protocol=ssh \
            git://git@github.ibm.com/openbmc/ekb;destsuffix=git/ekb;name=ekb;branch=master-p10;protocol=ssh"

SRC_URI += "file://enable-istep0-procedures-only-p10.patch"
SRC_URI += "file://fapi-attributes-xml.patch"
SRC_URI += "file://ekb_SegFault_Fix.patch"
SRC_URI += "file://ekb_Add_missing_include_file_required_for_memcpy.patch"

DEPENDS = "pdbg pdata libxml-simple-perl-native"

BBCLASSEXTEND = "native"
