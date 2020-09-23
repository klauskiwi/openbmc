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
SRCREV = "482dce5b719fe83e8bb19b8df1b5f1328b3cc4c7"

SRC_URI += "file://enable-istep0-procedures-only-p9.patch"

IPL_EKB_DEPENDS = ""
IPL_EKB_DEPENDS_ibm-power9-cpu = "libekb"
IPL_EKB_DEPENDS_ibm-power10-cpu = "libekb-p10"
DEPENDS = " \
        ${IPL_EKB_DEPENDS} pdbg autoconf-archive guard \
        "

RDEPENDS_${PN} = "power-devtree"

EXTRA_OECONF_ibm-power9-cpu = "CHIP=p9"
EXTRA_OECONF_ibm-power10-cpu = "CHIP=p10"
