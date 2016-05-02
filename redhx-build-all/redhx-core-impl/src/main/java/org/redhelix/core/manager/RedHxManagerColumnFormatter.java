package org.redhelix.core.manager;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.redhelix.core.util.RedHxAbstractColumnFormatter;

/**
 * print the contents of a manager to a stream
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 *
 */
public final class RedHxManagerColumnFormatter extends RedHxAbstractColumnFormatter {

  /**
   * output in ALPH format. No section headers are printed.
   *
   * @param isRowTitlePrinted
   * @param columnDelimiter
   * @param outputOrder
   * @param isPathPrinted
   */
  public RedHxManagerColumnFormatter(boolean isRowTitlePrinted, String columnDelimiter,
      boolean isPathPrinted) {
    super(isRowTitlePrinted, columnDelimiter, isPathPrinted);
  }

  /**
   * output the rows in sections and optionaly print a section header.
   *
   * @param isRowTitlePrinted
   * @param columnDelimiter
   * @param isSectionHeaderPrinted
   * @param isPathPrinted
   */
  public RedHxManagerColumnFormatter(boolean isRowTitlePrinted, String columnDelimiter,
      boolean isSectionHeaderPrinted, boolean isPathPrinted) {
    super(isRowTitlePrinted, columnDelimiter, isSectionHeaderPrinted, isPathPrinted);
  }

  public void print(RedHxManager computerSystem, PrintStream streamOut) {
    super.clearRows();
    switch (super.getOutputOrder()) {
      case ALPHA:
        printAlphaOrder(computerSystem, streamOut);

        break;
      case SECTION:
        printSectionOrder(computerSystem, streamOut);

        break;
      default:
        throw new IllegalArgumentException("Unknown format order " + getOutputOrder());
    }
  }

  private void createRows(RedHxManager computerSystem,
      Map<Integer, String> rowNumberToSectionHeaderMap) {
    String prompt;

    /*
     * ID section
     */
    rowNumberToSectionHeaderMap.put(super.getRowCount(), "Manager Identification");

    /**
     * The URI Path always is present and not null.
     */
    prompt = "URI Path";
    addRow(prompt, computerSystem.getManagerPath().getValue());

    /*
     *
     */
    prompt = "Manager ID";

    if (computerSystem.getManagerId() != null) {
      addRow(prompt, computerSystem.getManagerId().getValue());
    } else {
      addRow(prompt);
    }

    prompt = "Name";
    
    if (computerSystem.getManagerName() != null) {
    	addRow(prompt, computerSystem.getManagerName().getValue());
    } else {
    	addRow(prompt);
    }
    
    prompt = "Manager Type";
    
    if (computerSystem.getManagerType() != null) {
    	addRow(prompt, computerSystem.getManagerType().toString());
    } else {
    	addRow(prompt);
    }
    
    prompt = "Service Entry Point UUID ";
    
    if (computerSystem.getServiceEntryPointUUID() != null) {
    	addRow(prompt, computerSystem.getServiceEntryPointUUID().toString());
    } else {
    	addRow(prompt);
    }
    
    prompt = "Description";

    if (computerSystem.getManagerDescription() != null) {
      addRow(prompt, computerSystem.getManagerDescription().getValue());
    } else {
      addRow(prompt);
    }
    
    prompt = "UUID ";
    
    if (computerSystem.getUuid() != null) {
    	addRow(prompt, computerSystem.getUuid().toString());
    } else {
    	addRow(prompt);
    }

    prompt = "Model";

    if (computerSystem.getManagerModel() != null) {
      addRow(prompt, computerSystem.getManagerModel().getValue());
    } else {
      addRow(prompt);
    }
    
    prompt = "Date Time";
    
    if (computerSystem.getDateTime() != null) {
    	addRow(prompt, computerSystem.getDateTime().toString());
    } else {
    	addRow(prompt);
    }
    
    prompt = "Date Time local Of Set";
    
    if (computerSystem.getDateTimeLocalOffset() != null) {
    	addRow(prompt, computerSystem.getDateTimeLocalOffset().toString());
    } else {
    	addRow(prompt);
    }
    
    prompt = "Firmware Version";
    
    if (computerSystem.getFirmwareVersion() != null) {
    	addRow(prompt, computerSystem.getFirmwareVersion().getValue());
    } else {
    	addRow(prompt);
    }

    prompt = "Status";

    if (computerSystem.getStatus() != null) {
      addRow(prompt, computerSystem.getStatus() + " ");
    } else {
      addRow(prompt);
    }

    /*
     * Paths
     */
    if (isPathPrinted()) {
      rowNumberToSectionHeaderMap.put(super.getRowCount(), "Manager Paths");
      
      
      
    }
  }

  private void printAlphaOrder(RedHxManager computerSystem, PrintStream streamOut) {

    /**
     * create the map but it will be ignored when actually printed out.
     */
    Map<Integer, String> rowNumberToSectionHeaderMap = new HashMap<>();

    createRows(computerSystem, rowNumberToSectionHeaderMap);

    /**
     * calling this print method sorts the output in Alpha order.
     */
    printOutRowsAlphaOrder(streamOut);
  }

  private void printSectionOrder(RedHxManager computerSystem, PrintStream streamOut) {
    Map<Integer, String> rowNumberToSectionHeaderMap = new HashMap<>();

    createRows(computerSystem, rowNumberToSectionHeaderMap);
    printOutRowsWithSectionTitles(streamOut, rowNumberToSectionHeaderMap);
  }
}
