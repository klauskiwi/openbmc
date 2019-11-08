SUMMARY     = "eCMD plugin with pdbg backend"
DESCRIPTION = "The glue code necessary for pdbg to be used as an eCMD plugin"
PR = "r1"
PV = "1.0+git${SRCPV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

inherit meson
inherit pkgconfig

SRC_URI = "git://git@github.ibm.com/phal/ecmd-pdbg.git;nobranch=1;protocol=ssh"
SRCREV = "9bfb34eabd8d41440228534c6560946c187216ee"

S = "${WORKDIR}/git"

DEPENDS = "pdbg zlib libyaml ipl"

FILES_${PN} += "${prefix}/help"

EXTRA_OEMESON = " \
        -Dchip=p10 \
        "
