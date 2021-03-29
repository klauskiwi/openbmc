HOMEPAGE =  "https://github.ibm.com/phal/ipl_p10/"

SUMMARY     = "Initial Program Load steps"
DESCRIPTION = "Provides infrastructure to run istep"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit autotools phal

S = "${WORKDIR}/git"

SRC_URI = "git://git@github.ibm.com/phal/ipl;protocol=ssh"
SRCREV = "7fea846303771fd8e8766832835f3a8fc962580a"

SRC_URI += "file://enable-istep0-procedures-only-p9.patch"

DEPENDS = " \
        ${@getlibekb_depend(d)} pdbg autoconf-archive \
        "

RDEPENDS_${PN} = "power-devtree"

EXTRA_OECONF = "CHIP=${TARGET_PROC}"
