package org.redhelix.core.manager.GraphicalConsole;

public enum RedHxGraphicalConnectTypesSupported {

	KVMIP("KVMIP",
			"The controller supports a Graphical Console connection using a KVM-IP (redirection of Keyboard, Video, Mouse over IP) protocol"), 
	Oem("Oem", "The controller supports a Graphical Console connection using an OEM-specific protocol");

	private final String desc;
	private final String jsonKeyword;

	private RedHxGraphicalConnectTypesSupported(String jsonKeyword, String desc) {
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
	public static RedHxGraphicalConnectTypesSupported getInstance(String jsonKeyword) {
		RedHxGraphicalConnectTypesSupported retVal = null;

		for (RedHxGraphicalConnectTypesSupported tmp : values()) {
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
