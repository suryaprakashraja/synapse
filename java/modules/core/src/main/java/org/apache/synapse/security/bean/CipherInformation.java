/*
*  Licensed to the Apache Software Foundation (ASF) under one
*  or more contributor license agreements.  See the NOTICE file
*  distributed with this work for additional information
*  regarding copyright ownership.  The ASF licenses this file
*  to you under the Apache License, Version 2.0 (the
*  "License"); you may not use this file except in compliance
*  with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.apache.synapse.security.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.SynapseException;
import org.apache.synapse.security.tool.CipherTool;

/**
 * Encapsulates the cipher related information
 */
public class CipherInformation {

    private static final Log log = LogFactory.getLog(CipherInformation.class);

    private static String DEFAULT_ALGORITHM = "RSA";
    private String algorithm = DEFAULT_ALGORITHM;
    private String operationMode;
    private String mode;
    private String inType;
    private String outType;
    private String type;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        if (algorithm == null || "".equals(algorithm)) {
            if (log.isDebugEnabled()) {
                log.debug("Given algorithm is null, using a defaut one : RSA");
            }
        }
        this.algorithm = algorithm;
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        if (operationMode == null || "".equals(operationMode)) {
            handleException("Operation mode can not be null");
        }
        if (!CipherTool.ENCRYPT.equals(operationMode)
                && !CipherTool.DECRYPT.equals(operationMode)) {
            handleException("Invalid operation mode ' " + operationMode + " ' for cipher ");
        }
        this.operationMode = operationMode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    private void handleException(String msg) {
        log.error(msg);
        throw new SynapseException(msg);
    }
}
