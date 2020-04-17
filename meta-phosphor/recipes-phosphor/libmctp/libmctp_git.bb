SUMMARY = "MCTP Library"
DESCRIPTION = "Provides low-level MCTP packet support"
LICENSE = "Apache-2.0 | GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d30807bb7a4f16d36e96b78f9ed8fae"
SRC_URI = "git://git@github.ibm.com/openbmc/libmctp.git;protocol=ssh;branch=astlpc-mtu-248 \
           "
SRCREV = "4f70a4a342f85b3dca6f78094da5f8d111dd4941"

PR = "r1"
PV = "0.9+git${SRCPV}"

inherit autotools
inherit systemd

DEPENDS += "autoconf-archive-native"
DEPENDS += "pkgconfig"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"
PACKAGECONFIG[systemd] = "--with-systemdsystemunitdir=${systemd_system_unitdir}, \
                          --without-systemdsystemunitdir,systemd"

SYSTEMD_SERVICE_${PN} += "mctp-demux.service"
