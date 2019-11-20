SIMICS_VERSION = "5.0.187"

PV = "${SIMICS_VERSION}+git${SRCPV}"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "git://git@github.ibm.com/PowerSimulation/simbase;branch=simics-${SIMICS_VERSION};subpath=${SIMICS_SUBDIR};destsuffix=git/;protocol=ssh"
SRCREV = "129702702bb03b50329e6c3c935abba797f4400c"

S = "${WORKDIR}/git"

# By default assume makefiles are well behaved and don't set CFLAGS.
EXTRA_OEMAKE ?= "'CC=${CC}' 'CFLAGS=${CFLAGS}' 'LDFLAGS=${LDFLAGS}'"

do_compile() {
    oe_runmake -C ${S} all
}

python() {
    if not d.getVar('SIMICS_SUBDIR', True):
        bb.fatal('SIMICS_SUBDIR must be set when inheriting simics.bbclass')
}
