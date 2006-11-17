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

package samples.proxy;

import samples.common.Util;

public class ProxyStockQuoteClient {

    public static void main(String[] args) {

        String symbol   = "IBM";
        String fwdProxy = "http://localhost:8080/axis2/services/InvesbotForwardProxy";
        String defProxy = "http://localhost:8080/axis2/services/InvesbotDefaultProxy";
        String seqProxy = "http://localhost:8080/axis2/services/InvesbotSequenceProxy";
        String repo     = "client_repo";
        String sAction  = "http://ws.invesbot.com/GetQuote";

        if (args.length > 0) symbol   = args[0];
        if (args.length > 1) fwdProxy = args[1];
        if (args.length > 2) defProxy = args[2];
        if (args.length > 3) seqProxy = args[3];
        if (args.length > 4) repo     = args[4];

        Util.testStandardQuote(symbol, sAction, null, fwdProxy, repo);
        Util.testStandardQuote(symbol, sAction, null, defProxy, repo);
        Util.testStandardQuote(symbol, sAction, null, seqProxy, repo);
    }
}
