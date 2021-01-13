SUMMARY = "Secure-boot utilities for ASPEED BMC SoCs"
HOMEPAGE = "https://github.com/AspeedTech-BMC/socsec/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d50b901333b4eedfee074ebcd6a6d611"

SRC_URI = "git://github.com/AspeedTech-BMC/socsec/;protocol=https \
           file://0001-socsec-Ignore-non-key-data-on-PEM-key-files.patch \
           file://0002-ast2600-Allow-for-SPL-as-large-as-64Kb-512b.patch \
           "

PV = "1.7+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit python3native setuptools3

RDEPENDS_${PN} += "python3-bitarray"
RDEPENDS_${PN} += "python3-core"
RDEPENDS_${PN} += "python3-hexdump"
RDEPENDS_${PN} += "python3-jsonschema"
RDEPENDS_${PN} += "python3-jstyleson"
RDEPENDS_${PN} += "python3-pycryptodome"

BBCLASSEXTEND = "native nativesdk"
