package org.redhelix.core.manager.CommandShel;

public enum RedHxCommandConnectTypesSupported {

	SSH("SSH", "The controller supports a Command Shell connection using the SSH protocol"), Telnet("Telnet",
			"The controller supports a Command Shell connection using the SSH protocol"), IPMI("IPMI",
					"The controller supports a Command Shell connection using the SSH protocol"), Oem("Oem",
							"The controller supports a Command Shell connection using an OEM-specific protocol");

	private final String desc;
	private final String jsonKeyword;

	private RedHxCommandConnectTypesSupported(String jsonKeyword, String desc) {
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
	public static RedHxCommandConnectTypesSupported getInstance(String jsonKeyword) {
		RedHxCommandConnectTypesSupported retVal = null;

		for (RedHxCommandConnectTypesSupported tmp : values()) {
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
