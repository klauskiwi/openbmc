HOMEPAGE =  "https://github.ibm.com/phal/ipl_p10/"

SUMMARY     = "Initial Program Load steps"
DESCRIPTION = "Provides infrastructure to run istep"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit autotools

S = "${WORKDIR}/git"

SRC_URI = "git://git@github.ibm.com/phal/ipl;protocol=ssh"
SRCREV = "04ca607eded4adb7458d29660798cd8f29ab7f9f"

DEPENDS = " \
        libekb-p10 pdbg pdata autoconf-archive \
        "

RDEPENDS_${PN} = "generate-dtb"

EXTRA_OECONF = "CHIP=p10"
