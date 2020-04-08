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

SRCREV_libekb = "e3af3b246d7dbf20d81d74b55c163b1fde23d71a"
SRCREV_ekb = "289ff52f89894e39211150444ff3e9fc296e67df"

SRC_URI = "git://git@github.ibm.com/phal/libekb_p10;name=libekb;protocol=ssh \
           git://git@github.ibm.com/openbmc/ekb;destsuffix=git/ekb;name=ekb;branch=master-p10;protocol=ssh \
           file://fapi-attributes-xml.patch \
           "

DEPENDS = "pdbg pdata libxml-simple-perl-native"

# During compilation race condition issue is happening, so getting different
# different error due to make targets rule dependency ( mostly found auto code generation ).
# Hence, forcing this recipe to run make tool with single job
# instead in multi-job which is control by bitbake based on cpu.
# TODO ibm/openbmc/issues/278 : Actual fix should be in libekb makefile.
# Need to revisit once fixed in libekb makefile
PARALLEL_MAKE = "-j 1"

BBCLASSEXTEND = "native"
