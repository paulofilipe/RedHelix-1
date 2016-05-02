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

public interface RedHxManager {

	RedHxManagerId getManagerId();

	RedHxManagerDescription getManagerDescription();

	RedHxManagerName getManagerName();

	RedHxManagerType getManagerType();

	UUID getServiceEntryPointUUID();

	UUID getUuid();

	RedHxManagerModel getManagerModel();

	LocalDateTime getDateTime();

	ZoneId getDateTimeLocalOffset();

	RedHxOperatingStatus getStatus();

	RedHxManagerFirmwareVersion getFirmwareVersion();

	RedHxSerialConsole getSerialConsole();

	RedHxCommandShell getCommandShell();

	RedHxGraphicalConsole getGraphicalConsole();

	RedHxActionGroup getActionGroup();

	RedHxUriPath getNetworkProtocolPath();

	RedHxUriPath getEthernetInterfacesPath();

	RedHxUriPath getSerialInterfacesPath();

	RedHxUriPath getLogServicesPath();

	RedHxUriPath getVirtualMediaPath();

	RedHxUriPath getManagerPath();

	List<RedHxUriPath> getManagerForChassisList();

	List<RedHxUriPath> getManagerForServersList();
}