package org.redhelix.redhx.server.db.test3;

import org.apache.olingo.client.api.ODataClient;
import org.apache.olingo.client.api.communication.request.retrieve.ODataServiceDocumentRequest;
import org.apache.olingo.client.api.communication.response.ODataRetrieveResponse;
import org.apache.olingo.client.api.domain.ClientServiceDocument;
import org.apache.olingo.client.core.ODataClientFactory;
import org.apache.olingo.commons.api.format.ContentType;
import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;
import org.junit.BeforeClass;
import org.junit.Test;

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
 *
 */
/**
 *
 *
 * @since RedHelix Version 0.2
 * @author Hank Bruning
 *
 */
public final class DiscoveryTest {

  private static TJWSEmbeddedJaxrsServer embeddedServer;

  @BeforeClass
  public static void beforeClass() throws Exception {
    embeddedServer = RedHelixTestServer.startServer();
  }

  @Test
  public void getMetaData() throws Exception {
    ODataClient client = ODataClientFactory.getClient();
    String url = "http://localhost:" + RedHelixTestServer.TCP_PORT_NUMBER
        + RedHelixTestServer.HTTP_URL + "/$metadata";
    ODataServiceDocumentRequest req =
        client.getRetrieveRequestFactory().getServiceDocumentRequest(url);

    req.setFormat(ContentType.APPLICATION_XML);

    ODataRetrieveResponse<ClientServiceDocument> res = req.execute();
  }
}
