package org.redhelix.core.manager.GraphicalConsole.SerialConsole;

public enum RedHxSerialConnectTypesSupported {
	SSH("SSH", "The controller supports a Serial Console connection using the SSH protocol"), Telnet("Telnet",
			"The controller supports a Serial Console connection using the Telnet protocol"), IPMI("IPMI",
					"The controller supports a Serial Console connection using the IPMI Serial-over-LAN (SOL) protocol"), Oem(
							"Oem", "The controller supports a Serial Console connection using an OEM-specific protoco");

	private final String desc;
	private final String jsonKeyword;

	private RedHxSerialConnectTypesSupported(String jsonKeyword, String desc) {
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
	public static RedHxSerialConnectTypesSupported getInstance(String jsonKeyword) {
		RedHxSerialConnectTypesSupported retVal = null;

		for (RedHxSerialConnectTypesSupported tmp : values()) {
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
