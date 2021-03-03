HOMEPAGE = "https://github.com/AspeedTech-BMC/u-boot"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"

# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "e5133640e9ea76767d50d3562697a4770e649bef"

SRC_URI = "git://git@github.com/shenki/u-boot.git;branch=common-mmc-loader;protocol=https"

S = "${WORKDIR}/git"

PV = "v2021.02+git${SRCPV}"
