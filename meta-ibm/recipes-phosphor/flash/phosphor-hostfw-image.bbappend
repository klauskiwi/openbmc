HOST_FW_LICENSE = "Proprietary"

SRC_URI = "https://rchweb.rchland.ibm.com/afs/rchland/projects/esw/${RELEASE}/Builds/${VERSION}/images/lab/${TARBALL_NAME}"

# Rainier
RELEASE_rainier ?= "fw1020"
VERSION_rainier ?= "1020.2116.20210412b"
TARBALL_NAME_rainier ?= "obmc-phosphor-image-rainier.ext4.mmc.tar;name=rainier"
SRC_URI[rainier.sha256sum] = "00b99e4a4a5f8eac57b86b4e1d193e5aa7ac305bf77cb1a86c95843878c045c2"

# Tacoma
RELEASE_witherspoon-tacoma ?= "fw1009"
VERSION_witherspoon-tacoma ?= "1009.2115.20210408a"
TARBALL_NAME_witherspoon-tacoma ?= "obmc-phosphor-image-witherspoon-tacoma.ext4.mmc.tar;name=tacoma"
SRC_URI[tacoma.sha256sum] = "65b33fe7562ddb3c29dbd13a6e29f418074cfb8e304c02de2149cba9c778a825"

S = "${WORKDIR}"
B = "${WORKDIR}/build"
do_compile[cleandirs] = "${B}"

do_compile_append() {
    install -m 0440 ${S}/image-hostfw ${B}/image/hostfw-a
    install -m 0440 ${S}/image-hostfw ${B}/image/hostfw-b
    install -m 0440 ${S}/image-hostfw ${B}/update/image-hostfw
}
