SUMMARY = "MCTP Library"
DESCRIPTION = "Provides low-level MCTP packet support"
LICENSE = "Apache-2.0 | GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d30807bb7a4f16d36e96b78f9ed8fae"
SRC_URI = "git://git@github.ibm.com/openbmc/libmctp.git;protocol=ssh;branch=astlpc-mtu-248 \
           "
SRCREV = "4f488ee14111fa6d601d9c1f25d3d8cdbd6121c3"

PR = "r1"
PV = "0.10+git${SRCPV}"

inherit autotools
inherit systemd

DEPENDS += "autoconf-archive-native"
DEPENDS += "pkgconfig"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"
PACKAGECONFIG[systemd] = "--with-systemdsystemunitdir=${systemd_system_unitdir}, \
                          --without-systemdsystemunitdir,systemd"

SYSTEMD_SERVICE_${PN} += "mctp-demux.service"
