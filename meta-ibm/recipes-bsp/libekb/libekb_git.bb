HOMEPAGE =  "https://github.ibm.com/phal/libekb/"
SUMMARY     = "Hardware Procedure Framework"
DESCRIPTION = "Provides infrastructure to run p9 hardware procedures"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
S = "${WORKDIR}/git"

SRCREV_FORMAT = "libekb_ekb"
SRCREV_libekb = "b7e1b54011fdc8ad74eab8cc766f0476b122a11a"
SRCREV_ekb = "5c027d1e626094666e443fa42e2e2ca76097d4bc"

SRC_URI = "git://git@github.ibm.com/phal/libekb;name=libekb;protocol=ssh \
            git://git@github.ibm.com/openbmc/ekb;destsuffix=git/ekb;name=ekb;protocol=ssh"

SRC_URI += "file://enable-istep0-procedures-only.patch"

DEPENDS = "pdbg libxml-simple-perl-native"

inherit autotools \
        python3native \
        perlnative

BBCLASSEXTEND = "native"
