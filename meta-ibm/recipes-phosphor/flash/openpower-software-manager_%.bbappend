PACKAGECONFIG_append_ibm-ac-server = " verify_pnor_signature"
PACKAGECONFIG_append_mihawk = " verify_pnor_signature"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_df-phosphor-mmc += "file://0001-volatile-Preserve-original-in-eMMC.patch"
