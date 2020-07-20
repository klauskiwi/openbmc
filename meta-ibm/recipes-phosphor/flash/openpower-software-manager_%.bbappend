PACKAGECONFIG_append_ibm-ac-server = " verify_pnor_signature"
PACKAGECONFIG_append_mihawk = " verify_pnor_signature"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_df-phosphor-mmc += "file://0001-mmc-Add-read-only-directory-to-support-mboxd.patch"
