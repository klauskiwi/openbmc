FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_rainier = " file://mctp"

do_install_append_rainier() {
    install -d ${D}${sysconfdir}/default
    install -m 0644 ${WORKDIR}/mctp ${D}${sysconfdir}/default/mctp
}

SRC_URI_append_witherspoon-tacoma = " file://mctp"

do_install_append_witherspoon-tacoma() {
    install -d ${D}${sysconfdir}/default
    install -m 0644 ${WORKDIR}/mctp ${D}${sysconfdir}/default/mctp
}
