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
# This function is intended to add the MMC entries to fstab if 'phosphor-mmc' is in DIStro_FEATURES.
#
update_mmc_fstab () {
	if [ -e ${IMAGE_ROOTFS}/etc/fstab ]; then
		echo "/dev/mmcblk0p1  /boot   ext4    defaults    0   0" >> ${IMAGE_ROOTFS}/etc/fstab
		echo "/dev/mmcblk0p5  /var    ext4    defaults    0   0" >> ${IMAGE_ROOTFS}/etc/fstab
		echo "/dev/mmcblk0p6  /host-fw    ext4    defaults    0   0" >> ${IMAGE_ROOTFS}/etc/fstab
	fi
}
# Add MMC entries to fstab
ROOTFS_POSTPROCESS_COMMAND += '${@bb.utils.contains("DISTRO_FEATURES", 'phosphor-mmc', "update_mmc_fstab; ", "", d)}'
