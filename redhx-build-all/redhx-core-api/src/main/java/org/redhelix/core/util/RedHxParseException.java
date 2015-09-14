/*
 * Copyright 2015 JBlade LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License
 */
package org.redhelix.core.util;

import org.redhelix.core.service.root.RedHxServiceRootIdEum;

/**
 * Identify a problem parsing data to create a RedHelix class. This identifies the
 *
 *
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 *
 */
public class RedHxParseException extends Exception {

  private final RedHxServiceRootIdEum serviceRootId;

  public RedHxParseException(final RedHxServiceRootIdEum serviceRootId, String message) {
    super(message);
    this.serviceRootId = serviceRootId;
  }

  public RedHxServiceRootIdEum getServiceRootId() {
    return serviceRootId;
  }
}
