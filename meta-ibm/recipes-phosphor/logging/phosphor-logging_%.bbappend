PACKAGECONFIG_append_witherspoon-tacoma = " openpower-pels"
PACKAGECONFIG_append_rainier = " openpower-pels"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append_rainier = " file://ibm,rainier-2u_dev_callouts.json"
SRC_URI_append_rainier = " file://ibm,rainier-4u_dev_callouts.json"
FILES_${PN}_append_rainier = " ${datadir}/phosphor-logging/pels/ibm,rainier-2u_dev_callouts.json"
FILES_${PN}_append_rainier = " ${datadir}/phosphor-logging/pels/ibm,rainier-4u_dev_callouts.json"

do_install_append_rainier() {
    install -d ${D}/${datadir}/phosphor-logging/pels
    install -m 0644 ${WORKDIR}/ibm,rainier-2u_dev_callouts.json ${D}/${datadir}/phosphor-logging/pels/ibm,rainier-2u_dev_callouts.json
    install -m 0644 ${WORKDIR}/ibm,rainier-4u_dev_callouts.json ${D}/${datadir}/phosphor-logging/pels/ibm,rainier-4u_dev_callouts.json
}
