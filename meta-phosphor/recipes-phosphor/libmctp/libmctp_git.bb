SUMMARY = "MCTP Library"
DESCRIPTION = "Provides low-level MCTP packet support"
LICENSE = "Apache-2.0 | GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d30807bb7a4f16d36e96b78f9ed8fae"
SRC_URI = "git://github.com/dkodihal/libmctp-1"
SRCREV = "1248b07ed468d7030d0f0623395a9543fa152843"

PR = "r1"
PV = "0.9+git${SRCPV}"

inherit autotools
inherit obmc-phosphor-systemd

DEPENDS += "autoconf-archive-native"
DEPENDS += "systemd"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE_${PN} += "mctp-demux.service"
