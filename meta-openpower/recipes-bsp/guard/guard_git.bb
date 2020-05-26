HOMEPAGE =  "https://github.ibm.com/open-power/guard"
SUMMARY     = "GUARD the faulty components"
DESCRIPTION = "Provide a way to GUARD the faulty component from the system"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit meson

S = "${WORKDIR}/git"

SRC_URI = "git://git@github.ibm.com/open-power/guard;branch="master-p10";protocol=ssh"
SRCREV = "516c4ffb94682d39e648e79f8452655cd3ff65b6"

DEPENDS = "cli11"
