package org.redhelix.core.manager.id;

public enum RedHxManagerType {
	ManagementController("ManagementController","A controller used primarily to monitor or manage the operation of a device or system"),
	EnclosureManager("EnclosureManager","A controller which provides management functions for a chassis or group of devices or systems"),
	BMC ("BMC","A controller which provides management functions for a single computer system"),
	RackManager ("RackManager","A controller which provides management functions for a whole or part of a rack"),
	AuxiliaryController("AuxiliaryController","A controller which provides management functions for a particular subsystem or group of device");

	private final String desc;
	private final String jsonKeyword;

	private RedHxManagerType(String jsonKeyword, String desc) {
	    this.jsonKeyword = jsonKeyword;
	    this.desc = desc;
	  }

	public String getDescription() {
		return desc;
	}

	/**
	 * convert from the RedFish JSON keyword into the enumeration.
	 *
	 * @param jsonKeyword
	 *            the keyword to lookup.
	 * @return null if the argument is not a valid Redfish JSON keyword
	 *         otherwise the enumeration.
	 */
	public static RedHxManagerType getInstance(String jsonKeyword) {
		RedHxManagerType retVal = null;

		for (RedHxManagerType tmp : values()) {
			if (tmp.jsonKeyword.equals(jsonKeyword)) {
				retVal = tmp;

				break;
			}
		}

		return retVal;
	}

	/**
	 * get the JSON keyword that identifies the enum.
	 *
	 * @return a keyword. This has zero spaces. A null is not returned.
	 */
	public String getJsonKeyword() {
		return jsonKeyword;
	}
}
