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



package org.redhelix.core.chassis.id;

import org.redhelix.core.util.RedHxAbstractStringProperty;

/**
 * The chassis model name. This is sometimes known as the model number but Redfish allows a string containing non-numeric characters. Git
 * SHA: $Id$
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 *
 */
public final class RedHxChassisModelNumberImpl
        extends RedHxAbstractStringProperty
        implements RedHxChassisModelNumber
{
    /**
     * @param propName
     */
    public RedHxChassisModelNumberImpl( String propName )
    {
        super(MAX_CHAR_COUNT_RED_HELIX_DEFINED,
              propName);
    }
}
