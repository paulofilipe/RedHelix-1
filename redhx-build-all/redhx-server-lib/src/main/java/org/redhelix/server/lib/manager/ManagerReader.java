package org.redhelix.server.lib.manager;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import org.redhelix.core.action.RedHxActionProperties;
import org.redhelix.core.manager.RedHxManager;
import org.redhelix.core.manager.RedHxManagerBuilder;
import org.redhelix.core.service.root.RedHxServiceRootIdEum;
import org.redhelix.core.util.RedHxHttpResponseException;
import org.redhelix.core.util.RedHxOperatingStatus;
import org.redhelix.core.util.RedHxUriPath;
import org.redhelix.server.lib.reader.util.AbstractRedfishJsonReader;
import org.redhelix.server.lib.reader.util.RedHxServerConnectionContext;

public class ManagerReader extends AbstractRedfishJsonReader {

	private final static String JSON_KEY_ID = "Id";
	private final static String JSON_KEY_NAME = "Name";
	private final static String JSON_KEY_MANAGERTYPE = "ManagerType";
	private final static String JSON_KEY_DESCRIPTION = "Description";
	private final static String JSON_KEY_SERVICEENTRYPOINTUUID = "ServiceEntryPointUUID";
	private final static String JSON_KEY_UUID = "UUID";
	private final static String JSON_KEY_MODEL = "Model";
	private final static String JSON_KEY_DATETIME = "DateTime";
	private final static String JSON_KEY_DATETIMELOCALOFFSET = "DateTimeLocalOffset";
	private final static String JSON_KEY_STATUS = "Status";
	private final static String JSON_KEY_GRAPHICALCONSOLE = "GraphicalConsole";
	private final static String JSON_KEY_SERIALCONSOLE = "SerialConsole";
	private final static String JSON_KEY_COMMANDSHELL = "CommandShell";
	private final static String JSON_KEY_FIRMWAREVERSION = "FirmwareVersion";
	private final static String JSON_KEY_NETWORKPROTOCOL = "NetworkProtocol";
	private final static String JSON_KEY_ETHERNETINTERFACES = "EthernetInterfaces";
	private final static String JSON_KEY_SERIALINTERFACES = "SerialInterfaces";
	private final static String JSON_KEY_LOGSERVICES = "LogServices";
	private final static String JSON_KEY_VIRTUALMEDIA = "VirtualMedia";
	private final static String JSON_LINKS_KEY_MANAGERFORSERVERS = "ManagerForServers";
	private final static String JSON_LINKS_KEY_MANAGERFORCHASSIS = "ManagerForChassis";
	private final static String JSON_KEY_ACTIONS = "Actions";
	private final static String JSON_KEY_OEM = "Oem";

	protected ManagerReader(RedHxServerConnectionContext ctx, RedHxUriPath pathToResource)
			throws URISyntaxException, RedHxHttpResponseException {
		super(ctx, RedHxServiceRootIdEum.MANAGERS, pathToResource);
	}

	public RedHxManager readManager() {
		String tmpStr;
		RedHxManagerBuilder builder = new RedHxManagerBuilder(super.getUriPath());

		tmpStr = getOptionalProperty(JSON_KEY_ID);

		if (tmpStr != null) {
			builder.setManagerId(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_NAME);

		if (tmpStr != null) {
			builder.setManagerName(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_MANAGERTYPE);

		if (tmpStr != null) {
			builder.setManagerType(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_DESCRIPTION);

		if (tmpStr != null) {
			builder.setManagerDescription(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_SERVICEENTRYPOINTUUID);

		if (tmpStr != null) {
			builder.setServiceEntryPointUUID(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_UUID);

		if (tmpStr != null) {
			builder.setUuid(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_MODEL);

		if (tmpStr != null) {
			builder.setManagerModel(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_DATETIME);

		if (tmpStr != null) {
			builder.setDateTime(tmpStr);
		}

		tmpStr = getOptionalProperty(JSON_KEY_DATETIMELOCALOFFSET);

		if (tmpStr != null) {
			builder.setDateTimeLocalOffset(tmpStr);
		}

		RedHxOperatingStatus Status = getOperatingStatus(JSON_KEY_STATUS);

	    if (Status != null) {
	      builder.setStatus(Status);
	    }
		
		tmpStr = getOptionalProperty(JSON_KEY_FIRMWAREVERSION);
		
		if (tmpStr != null) {
			builder.setFirmwareVersion(tmpStr);
		}
		
		tmpStr = getAnnotation(JSON_KEY_NETWORKPROTOCOL);
		
		if (tmpStr != null) {
		    builder.setPathToNetworkProtocol(tmpStr);
		}
		
		tmpStr = getAnnotation(JSON_KEY_ETHERNETINTERFACES);
		
		if (tmpStr != null) {
			builder.setPathToEthernetInterfaces(tmpStr);
		}
		
		tmpStr = getAnnotation(JSON_KEY_SERIALINTERFACES);
		
		if (tmpStr != null) {
			builder.setPathToSerialInterfaces(tmpStr);
		}

		tmpStr = getAnnotation(JSON_KEY_LOGSERVICES);
		
		if (tmpStr != null) {
			builder.setPathToLogServices(tmpStr);
		}
		
		tmpStr = getAnnotation(JSON_KEY_VIRTUALMEDIA);
		
		if (tmpStr != null) {
			builder.setPathToVirtualMedia(tmpStr);
		}

		List<String> managerForChassisList = getLinkArray(JSON_LINKS_KEY_MANAGERFORCHASSIS);

	    if (managerForChassisList != null) {
	      builder.setManagerForChassisList(managerForChassisList);
	    }

	    List<String> managerForServersList = getLinkArray(JSON_LINKS_KEY_MANAGERFORSERVERS);
	    
	    if (managerForServersList != null) {
	      builder.setManagerForServersList(managerForServersList);
	    }
		
		Set<RedHxActionProperties> actionSet = getActions(JSON_KEY_ACTIONS);

		if (actionSet != null) {
			builder.setActionGroup(actionSet);
		}

		final RedHxManager manager = builder.getInstance();

		return manager;
	}

}
