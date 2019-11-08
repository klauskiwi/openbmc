HOMEPAGE =  "https://github.ibm.com/phal/libekb/"
SUMMARY     = "Hardware Procedure Framework"
DESCRIPTION = "Provides infrastructure to run p9 hardware procedures"
PR = "r1"
PV = "1.0+git${SRCPV}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
S = "${WORKDIR}/git"

SRCREV_FORMAT = "libekb_ekb"
SRCREV_libekb = "9418c5cc09fae037f25b24da76db9552cfcbb8bd"
SRCREV_ekb = "3ca154136d247d0b3e9d7f3408eeb573ce04e72f"

SRC_URI = "git://git@github.ibm.com/phal/libekb;name=libekb;protocol=ssh \
            git://git@github.ibm.com/openbmc/ekb;destsuffix=git/ekb;name=ekb;protocol=ssh"

SRC_URI += "file://enable-istep0-procedures-only.patch"

DEPENDS = "pdbg pdata"

inherit autotools \
        pythonnative

BBCLASSEXTEND = "native"
