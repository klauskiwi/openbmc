PACKAGECONFIG_append_witherspoon-tacoma = " openpower-pels"
PACKAGECONFIG_append_rainier = " openpower-pels"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

# As a workaround until entity-manager puts the system name on D-Bus, give the
# device callouts JSON file a name of _dev_callouts.json, which the code will
# look for after it fails to find a match using the system name.
SRC_URI_append_rainier += "file://_dev_callouts.json"
FILES_${PN}_append_rainier = "${datadir}/phosphor-logging/pels/_dev_callouts.json"

do_install_append_rainier() {
    install -d ${D}/${datadir}/phosphor-logging/pels
    install -m 0644 ${WORKDIR}/_dev_callouts.json ${D}/${datadir}/phosphor-logging/pels/_dev_callouts.json
}
