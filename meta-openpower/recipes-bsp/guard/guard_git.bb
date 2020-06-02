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
SRCREV = "6ea467ef100ae5362946cfa520dfb84829588e66"

DEPENDS = "cli11"

PACKAGECONFIG ??= "${@bb.utils.contains('OBMC_MACHINE_FEATURES', 'phal', 'phal', '', d)}"
PACKAGECONFIG[phal] = "-Ddevtree=enabled, -Ddevtree=disabled, pdata pdbg"
