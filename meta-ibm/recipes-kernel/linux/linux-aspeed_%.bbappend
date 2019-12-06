FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
pldm_kernel_patches = " \
    file://0001-dt-bindings-interrupt-controller-Add-Aspeed-SCU-inte.patch \
    file://0002-irqchip-Add-Aspeed-SCU-interrupt-controller.patch \
    file://0003-ARM-dts-aspeed-ast2500-Add-SCU-interrupt-controller.patch \
    file://0004-ARM-dts-aspeed-ast2600-Add-SCU-interrupt-controllers.patch \
    file://0005-dt-bindings-soc-Add-Aspeed-XDMA-Engine.patch \
    file://0006-drivers-soc-Add-Aspeed-XDMA-Engine-Driver.patch \
    file://0007-drivers-soc-xdma-Add-user-interface.patch \
    file://0008-ARM-dts-aspeed-ast2500-Add-XDMA-Engine.patch \
    file://0009-ARM-dts-aspeed-ast2600-Add-XDMA-Engine.patch \
    file://0010-ARM-dts-aspeed-witherspoon-Enable-XDMA-Engine.patch \
    file://0011-ARM-dts-aspeed-rainier-Enable-XDMA-engine.patch \
    file://0012-ARM-dts-aspeed-tacoma-Enable-XDMA-engine.patch \
    file://0001-misc-Add-MCTP-LPC-driver-for-ASPEED-KCS-devices.patch \
    file://0002-mctp-lpc-Emit-an-error-on-overrun.patch \
    file://0003-mctp-lpc-Leave-value-in-IDR-and-disable-IRQ-on-IRQ.patch \
    file://0004-mctp-lpc-Only-trigger-IRQ-on-ODR-write.patch \
    file://0002-ARM-dts-aspeed-rainier-Enable-KCS-device.patch \
"
SRC_URI_append_ibm-ac-server = " file://witherspoon.cfg ${pldm_kernel_patches}"
SRC_URI_append_rainier = " file://rainier.cfg ${pldm_kernel_patches}"
SRC_URI_append_mihawk = " file://mihawk.cfg"
