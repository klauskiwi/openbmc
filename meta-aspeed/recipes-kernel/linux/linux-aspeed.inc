DESCRIPTION = "Linux kernel for Aspeed"
SECTION = "kernel"
LICENSE = "GPLv2"

PROVIDES += "virtual/kernel"

KCONFIG_MODE="--alldefconfig"

KSRC ?= "git://github.com/openbmc/linux;protocol=git;branch=${KBRANCH}"
SRC_URI = "${KSRC}"
SRC_URI += " file://rsa_oem_fit_key.key;sha256sum=59d9571a2e11b1ddb1d02538d448d5bfb4d0da341ba6af7a45e38be3d0fa76b1 \
             file://rsa_oem_fit_key.crt;sha256sum=0fa0d59579fa19bc344d215f81c2315d9e04e5058a9926f108799e58bd8cca34"

LINUX_VERSION_EXTENSION ?= "-${SRCREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# From 5.6+ the COPYING file changed
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
