HOST_FW_LICENSE = "Proprietary"

SRC_URI = "https://rchweb.rchland.ibm.com/afs/rchland/projects/esw/${RELEASE}/Builds/${VERSION}/ebmc-pkg/images/lab/imprint/${TARBALL_NAME}"

# Rainier
RELEASE_rainier ?= "fw1020"
VERSION_rainier ?= "1020.2112.20210325a"
TARBALL_NAME_rainier ?= "obmc-phosphor-image-rainier.ext4.mmc.tar;name=rainier"
SRC_URI[rainier.sha256sum] = "e507293cf49396d00ca617461ef2974e5c09d3a3b578697fde226a726cef9faf"

# Tacoma
RELEASE_witherspoon-tacoma ?= "fw1009"
VERSION_witherspoon-tacoma ?= "1009.2113.20210322a"
TARBALL_NAME_witherspoon-tacoma ?= "obmc-phosphor-image-witherspoon-tacoma.ext4.mmc.tar;name=tacoma"
SRC_URI[tacoma.sha256sum] = "0b6c43b83897084635157effde96b5e88cc92072a932512c4a1988b66f8e5f35"

S = "${WORKDIR}"
B = "${WORKDIR}/build"
do_compile[cleandirs] = "${B}"

do_compile_append() {
    install -m 0440 ${S}/image-hostfw ${B}/image/hostfw-a
    install -m 0440 ${S}/image-hostfw ${B}/image/hostfw-b
    install -m 0440 ${S}/image-hostfw ${B}/update/image-hostfw
}
