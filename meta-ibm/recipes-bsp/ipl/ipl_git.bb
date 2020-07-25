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
SRCREV = "74049fd2ba94bf8b8c224e74250ada8b9575a280"

SRC_URI += "file://enable-istep0-procedures-only-p9.patch"

DEPENDS = " \
        ${@getlibekb_depend(d)} pdbg autoconf-archive guard \
        "

RDEPENDS_${PN} = "power-devtree"

EXTRA_OECONF = "CHIP=${TARGET_PROC}"
