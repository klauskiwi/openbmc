HOMEPAGE =  "https://github.ibm.com/phal/pdata/"

SUMMARY     = "POWER Host data management"
DESCRIPTION = "Device tree based POWER host data management"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

S = "${WORKDIR}/git"

inherit autotools

SRC_URI = "git://git@github.ibm.com/phal/pdata;protocol=ssh"
SRCREV = "aea322dfbbf1e80946e7743f7e583409664150b6"

DEPENDS = "pdbg"

BBCLASSEXTEND = "native"
