package org.redhelix.core.manager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.redhelix.core.action.RedHxActionGroup;
import org.redhelix.core.manager.CommandShel.RedHxCommandShell;
import org.redhelix.core.manager.GraphicalConsole.RedHxGraphicalConsole;
import org.redhelix.core.manager.GraphicalConsole.SerialConsole.RedHxSerialConsole;
import org.redhelix.core.manager.id.RedHxManagerDescription;
import org.redhelix.core.manager.id.RedHxManagerFirmwareVersion;
import org.redhelix.core.manager.id.RedHxManagerId;
import org.redhelix.core.manager.id.RedHxManagerModel;
import org.redhelix.core.manager.id.RedHxManagerName;
import org.redhelix.core.manager.id.RedHxManagerType;
import org.redhelix.core.util.RedHxOperatingStatus;
import org.redhelix.core.util.RedHxUriPath;
import org.redhelix.core.util.RedHxUriPathImpl;

public class ManagerImpl implements RedHxManager {

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
	private RedHxUriPath managerPath;
	private RedHxOperatingStatus status;
	private RedHxUriPath networkProtocol;
	private RedHxUriPath ethernetInterfaces;
	private RedHxUriPath serialInterfaces;
	private RedHxUriPath logServices;
	private RedHxUriPath virtualMedia;
	private List<RedHxUriPath> managerForChassisList;
	private List<RedHxUriPath> managerForServersList;

	public ManagerImpl(RedHxUriPath managerPath, RedHxManagerId managerId, RedHxManagerDescription managerDescription,
			RedHxManagerName managerName, RedHxManagerType managerType, UUID serviceEntryPointUUID, UUID uuid,
			RedHxManagerModel managerModel, LocalDateTime dateTime, ZoneId dateTimeLocalOffset,
			RedHxManagerFirmwareVersion firmwareVersion, RedHxSerialConsole serialConsole,
			RedHxCommandShell commandShell, RedHxGraphicalConsole graphicalConsole, RedHxActionGroup actionGroup, RedHxOperatingStatus status, RedHxUriPath networkProtocol,
			RedHxUriPath ethernetInterfaces, RedHxUriPath serialInterfaces, RedHxUriPath logServices, RedHxUriPath virtualMedia, List<RedHxUriPath> managerForChassisList, 
			List<RedHxUriPath> managerForServersList) {
		super();
		this.managerPath = managerPath;
		this.managerId = managerId;
		this.managerDescription = managerDescription;
		this.managerName = managerName;
		this.managerType = managerType;
		this.serviceEntryPointUUID = serviceEntryPointUUID;
		this.uuid = uuid;
		this.managerModel = managerModel;
		this.dateTime = dateTime;
		this.dateTimeLocalOffset = dateTimeLocalOffset;
		this.status = status;
		this.firmwareVersion = firmwareVersion;
		this.serialConsole = serialConsole;
		this.commandShell = commandShell;
		this.graphicalConsole = graphicalConsole;
		this.actionGroup = actionGroup;
		this.networkProtocol = networkProtocol;
		this.ethernetInterfaces = ethernetInterfaces;
		this.serialInterfaces = serialInterfaces;
		this.logServices = logServices;
		this.virtualMedia = virtualMedia;
		this.managerForChassisList = managerForChassisList;
		this.managerForServersList = managerForServersList;
	}

	public ManagerImpl() {
		super();
	}

	@Override
	public RedHxManagerId getManagerId() {
		return managerId;
	}

	@Override
	public RedHxManagerDescription getManagerDescription() {
		return managerDescription;
	}

	@Override
	public RedHxManagerName getManagerName() {
		return managerName;
	}

	@Override
	public RedHxManagerType getManagerType() {
		return managerType;
	}

	@Override
	public UUID getServiceEntryPointUUID() {
		return serviceEntryPointUUID;
	}

	@Override
	public UUID getUuid() {
		return uuid;
	}

	@Override
	public RedHxManagerModel getManagerModel() {
		return managerModel;
	}

	@Override
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public ZoneId getDateTimeLocalOffset() {
		return dateTimeLocalOffset;
	}

	@Override
	public RedHxManagerFirmwareVersion getFirmwareVersion() {
		return firmwareVersion;
	}

	@Override
	public RedHxSerialConsole getSerialConsole() {
		return serialConsole;
	}

	@Override
	public RedHxCommandShell getCommandShell() {
		return commandShell;
	}

	@Override
	public RedHxGraphicalConsole getGraphicalConsole() {
		return graphicalConsole;
	}

	@Override
	public RedHxActionGroup getActionGroup() {
		return actionGroup;
	}

	@Override
	public String toString() {
		StringBuilder toStringBuilder;
	    toStringBuilder = new StringBuilder("ManagerImpl{");
	    toStringBuilder.append("ManagerId=").append(this.managerId);
	    toStringBuilder.append(",ManagerDescription=").append(this.managerDescription);
	    toStringBuilder.append(",ManagerName=").append(this.managerName);
	    toStringBuilder.append(",ManagerType=").append(this.managerType);
	    toStringBuilder.append(",ServiceEntryPointUUID=").append(this.serviceEntryPointUUID);
	    toStringBuilder.append(",UUID=").append(this.uuid);
	    toStringBuilder.append(",ManagerModel=").append(this.managerModel);
	    toStringBuilder.append(",DateTime=").append(this.dateTime);
	    toStringBuilder.append(",DateTimeLocalOffset=").append(this.dateTimeLocalOffset);
	    toStringBuilder.append(",FirmwareVersion=").append(this.firmwareVersion);
	    toStringBuilder.append(",SerialConsole=").append(this.serialConsole);
	    toStringBuilder.append(",CommandShell=").append(this.commandShell);
	    toStringBuilder.append(",GraphicalConsole=").append(this.graphicalConsole);
	    toStringBuilder.append(",ActionGroup=").append(this.actionGroup);
	    toStringBuilder.append('}');
	    return toStringBuilder.toString();
	}

	@Override
	public RedHxUriPath getManagerPath() {
		return managerPath;
	}

	@Override
	public RedHxOperatingStatus getStatus() {
		return status;
	}

	@Override
	public RedHxUriPath getNetworkProtocolPath() {
		return networkProtocol;
	}

	@Override
	public RedHxUriPath getEthernetInterfacesPath() {
		return ethernetInterfaces;
	}

	@Override
	public RedHxUriPath getSerialInterfacesPath() {
		return serialInterfaces;
	}

	@Override
	public RedHxUriPath getLogServicesPath() {
		return logServices;
	}

	@Override
	public RedHxUriPath getVirtualMediaPath() {
		return virtualMedia;
	}

	@Override
	public List<RedHxUriPath> getManagerForChassisList() {
		return managerForChassisList;
	}
	
	@Override
	public List<RedHxUriPath> getManagerForServersList() {
		return managerForServersList;
	}
}
