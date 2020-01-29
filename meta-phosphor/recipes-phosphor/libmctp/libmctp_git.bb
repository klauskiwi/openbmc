SUMMARY = "MCTP Library"
DESCRIPTION = "Provides low-level MCTP packet support"
LICENSE = "Apache-2.0 | GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d30807bb7a4f16d36e96b78f9ed8fae"
SRC_URI = "git://git@github.ibm.com/openbmc/libmctp.git;protocol=ssh;branch=astlpc-mtu-248"
SRCREV = "1890d65fc9e1179666e3c7def2d2aa9a76cc8620"

PR = "r1"
PV = "0.9+git${SRCPV}"

inherit autotools
inherit obmc-phosphor-systemd

DEPENDS += "autoconf-archive-native"
DEPENDS += "systemd"
DEPENDS += "pkgconfig"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE_${PN} += "mctp-demux.service"
