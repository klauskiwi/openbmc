SUMMARY = "MCTP Library"
DESCRIPTION = "Provides low-level MCTP packet support"
LICENSE = "Apache-2.0 | GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0d30807bb7a4f16d36e96b78f9ed8fae"
SRC_URI = "git://git@github.ibm.com/openbmc/libmctp.git;protocol=ssh;branch=astlpc-mtu-248 \
           "
SRCREV = "0b20b2a20554c2c103c4580ba00100e8a553d42a"

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
