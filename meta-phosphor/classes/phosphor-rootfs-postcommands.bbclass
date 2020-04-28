#
# This function is intended to add root to corresponding groups if 'debug-tweaks' or 'allow-root-login' is in IMAGE_FEATURES.
#
update_root_user_groups () {
	if [ -e ${IMAGE_ROOTFS}/etc/group ]; then
		sed -i '/^\(ipmi\|web\|redfish\|priv-admin\):.*:.*:$/s/$/root/' ${IMAGE_ROOTFS}/etc/group
	fi
}
# Add root user to the needed groups
ROOTFS_POSTPROCESS_COMMAND += '${@bb.utils.contains_any("IMAGE_FEATURES", [ 'debug-tweaks', 'allow-root-login' ], "update_root_user_groups; ", "", d)}'

#
# This function creates an image with the host-fw content to be used during code update on the eMMC
#
generate_hostfw_image () {
	if [ -e ${IMAGE_ROOTFS}/usr/share/host-fw/BOOTKERNEL.phyp ]; then
		mksquashfs ${IMAGE_ROOTFS}/usr/share/host-fw/* ${IMGDEPLOYDIR}/image-hostfw -all-root

		# Remove the OPAL BOOTKERNEL file, it doesn't fit in the NOR rootfs
		rm ${IMAGE_ROOTFS}/usr/share/host-fw/BOOTKERNEL.opal
	fi
}
# Generate the hostfw image
ROOTFS_POSTPROCESS_COMMAND += "generate_hostfw_image;"
