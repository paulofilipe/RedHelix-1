package org.redhelix.core.manager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.redhelix.core.action.RedHxActionGroup;
import org.redhelix.core.action.RedHxActionGroupImpl;
import org.redhelix.core.action.RedHxActionProperties;
import org.redhelix.core.manager.CommandShel.RedHxCommandShell;
import org.redhelix.core.manager.GraphicalConsole.RedHxGraphicalConsole;
import org.redhelix.core.manager.GraphicalConsole.SerialConsole.RedHxSerialConsole;
import org.redhelix.core.manager.id.RedHxManagerDescription;
import org.redhelix.core.manager.id.RedHxManagerDescriptionImpl;
import org.redhelix.core.manager.id.RedHxManagerFirmwareVersion;
import org.redhelix.core.manager.id.RedHxManagerFirmwareVersionImpl;
import org.redhelix.core.manager.id.RedHxManagerId;
import org.redhelix.core.manager.id.RedHxManagerIdImpl;
import org.redhelix.core.manager.id.RedHxManagerModel;
import org.redhelix.core.manager.id.RedHxManagerModelImpl;
import org.redhelix.core.manager.id.RedHxManagerName;
import org.redhelix.core.manager.id.RedHxManagerNameImpl;
import org.redhelix.core.manager.id.RedHxManagerType;
import org.redhelix.core.util.RedHxOperatingStatus;
import org.redhelix.core.util.RedHxUriPath;
import org.redhelix.core.util.RedHxUriPathImpl;

public class RedHxManagerBuilder {

	private final RedHxUriPath managerPath;
	private RedHxManagerId managerId;
	private RedHxManagerDescription managerDescription;
	private RedHxManagerName managerName;
	private RedHxManagerType managerType;
	private UUID serviceEntryPointUUID;
	private UUID uuid;
	private RedHxManagerModel managerModel;
	private LocalDateTime dateTime;
	private ZoneId dateTimeLocalOffset;
	private RedHxManagerFirmwareVersion firmwareVersion;
	private RedHxSerialConsole serialConsole;
	private RedHxCommandShell commandShell;
	private RedHxGraphicalConsole graphicalConsole;
	private RedHxActionGroup actionGroup;
	private RedHxOperatingStatus status;
	private RedHxUriPath networkProtocol;
	private RedHxUriPath ethernetInterfaces;
	private RedHxUriPath serialInterfaces;
	private RedHxUriPath logServices;
	private RedHxUriPath virtualMedia;
	private List<RedHxUriPath> managerForChassisList;
	private List<RedHxUriPath> managerForServersList;

	public RedHxManagerBuilder(RedHxUriPath managerPath) {
		super();
		this.managerPath = managerPath;

		if (managerPath == null) {
			throw new IllegalArgumentException("The argument computerSystemPath may not be null.");
		}
	}

	public ManagerImpl getInstance() {

		ManagerImpl manager = new ManagerImpl(managerPath, managerId, managerDescription, managerName, managerType,
				serviceEntryPointUUID, uuid, managerModel, dateTime, dateTimeLocalOffset, firmwareVersion,
				serialConsole, commandShell, graphicalConsole, actionGroup, status, networkProtocol, ethernetInterfaces,
				serialInterfaces, logServices, virtualMedia, managerForChassisList, managerForServersList);

		return manager;
	}

	public void setManagerId(final String value) {
		if (!value.isEmpty()) {
			managerId = new RedHxManagerIdImpl(value);
		} else {
			managerId = null;
		}
	}

	public void setManagerDescription(final String value) {
		if (!value.isEmpty()) {
			managerDescription = new RedHxManagerDescriptionImpl(value);
		} else {
			managerDescription = null;
		}
	}

	public void setManagerName(final String value) {
		if (!value.isEmpty()) {
			managerName = new RedHxManagerNameImpl(value);
		} else {
			managerName = null;
		}
	}

	public void setManagerType(final String value) {
		if (!value.isEmpty()) {
			managerType = RedHxManagerType.getInstance(value);
		} else {
			managerType = null;
		}
	}

	public void setServiceEntryPointUUID(final String value) {
		if (!value.isEmpty()) {
			serviceEntryPointUUID = UUID.fromString(value);
		} else {
			serviceEntryPointUUID = null;
		}
	}

	public void setUuid(final String value) {
		if (!value.isEmpty()) {
			uuid = UUID.fromString(value);
		} else {
			uuid = null;
		}
	}

	public void setManagerModel(final String value) {
		if (!value.isEmpty()) {
			managerModel = new RedHxManagerModelImpl(value);
		} else {
			managerModel = null;
		}
	}

	public void setDateTime(final String value) {
		if (!value.isEmpty()) {
			dateTime = LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		} else {
			dateTime = null;
		}
	}

	public void setDateTimeLocalOffset(final String value) {
		if (!value.isEmpty()) {
			dateTimeLocalOffset = ZoneId.of(value);
		} else {
			dateTimeLocalOffset = null;
		}
	}

	public void setStatus(RedHxOperatingStatus status) {
		this.status = status;
	}

	public void setFirmwareVersion(final String value) {
		if (!value.isEmpty()) {
			firmwareVersion = new RedHxManagerFirmwareVersionImpl(value);
		} else {
			firmwareVersion = null;
		}
	}

	public void setSerialConsole(RedHxSerialConsole serialConsole) {
		this.serialConsole = serialConsole;
	}

	public void setCommandShell(RedHxCommandShell commandShell) {
		this.commandShell = commandShell;
	}

	public void setGraphicalConsole(RedHxGraphicalConsole graphicalConsole) {
		this.graphicalConsole = graphicalConsole;
	}

	public void setActionGroup(Set<RedHxActionProperties> actionSet) {
		actionGroup = new RedHxActionGroupImpl(actionSet);
	}

	public void setPathToNetworkProtocol(String value) {
		if (!value.isEmpty()) {
			networkProtocol = new RedHxUriPathImpl(value);
		} else {
			networkProtocol = null;
		}
	}

	public void setPathToEthernetInterfaces(String value) {
		if (!value.isEmpty()) {
			ethernetInterfaces = new RedHxUriPathImpl(value);
		} else {
			ethernetInterfaces = null;
		}
	}

	public void setPathToSerialInterfaces(String value) {
		if (!value.isEmpty()) {
			serialInterfaces = new RedHxUriPathImpl(value);
		} else {
			serialInterfaces = null;
		}
	}

	public void setPathToLogServices(String value) {
		if (!value.isEmpty()) {
			logServices = new RedHxUriPathImpl(value);
		} else {
			logServices = null;
		}
	}

	public void setPathToVirtualMedia(String value) {
		if (!value.isEmpty()) {
			virtualMedia = new RedHxUriPathImpl(value);
		} else {
			virtualMedia = null;
		}
	}

	public void setManagerForChassisList(List<String> valueList) {
		List<RedHxUriPathImpl> list = new ArrayList<>();

	    for (String str : valueList) {
	      list.add(new RedHxUriPathImpl(str));
	    }

	    Collections.sort(list);
	    managerForChassisList = Collections.unmodifiableList(list);
	}

	public void setManagerForServersList(List<String> valueList) {
		List<RedHxUriPathImpl> list = new ArrayList<>();

	    for (String str : valueList) {
	      list.add(new RedHxUriPathImpl(str));
	    }

	    Collections.sort(list);
	    managerForServersList = Collections.unmodifiableList(list);
	}

}
