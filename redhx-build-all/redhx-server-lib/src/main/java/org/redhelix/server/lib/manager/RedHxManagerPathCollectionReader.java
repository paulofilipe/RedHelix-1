package org.redhelix.server.lib.manager;

import java.net.HttpURLConnection;
import java.util.HashSet;
import java.util.Set;

import org.apache.olingo.client.api.communication.response.ODataRetrieveResponse;
import org.apache.olingo.client.api.domain.ClientAnnotation;
import org.apache.olingo.client.api.domain.ClientComplexValue;
import org.apache.olingo.client.api.domain.ClientEntity;
import org.apache.olingo.client.api.domain.ClientProperty;
import org.apache.olingo.client.api.domain.ClientValue;
import org.redhelix.core.manager.RedHxManagerParseException;
import org.redhelix.core.service.root.RedHxServiceRootIdEum;
import org.redhelix.core.util.RedHxHttpResponseException;
import org.redhelix.core.util.RedHxUriPath;
import org.redhelix.core.util.RedHxUriPathImpl;
import org.redhelix.server.lib.reader.util.RedHxServerConnectionContext;

/**
 * read zero or more links, each one pointing to a unique managers. This class does not have a
 * constructor only a static method.
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 *
 */
public final class RedHxManagerPathCollectionReader {

  /**
   * The JSON property that identifies an array of managers. This is derived from the Redfish file
   * ManagersCollection.json.
   */
  private static final String JSON_MANAGERS_COLLECTION_KEYWORD = "Members";

  /**
   * This identifies the URL to a single managers.
   */
  private static final String ODATA_SINGLE_MANAGERS_KEYWORD = "odata.id";

  private RedHxManagerPathCollectionReader() {}

  /**
   * get a set of Paths used to identify unique managers. Each Path can be used in a URL to identify
   * a managers.
   *
   * @param ctx the communication context to single Redfish server.
   * @return A set of Paths. No element in the set is null.
   * @throws RedHxManagerParseException
   * @throws RedHxHttpResponseException
   */
  public static Set<RedHxUriPath> readManagersCollection(RedHxServerConnectionContext ctx)
      throws RedHxManagerParseException, RedHxHttpResponseException {
    final ODataRetrieveResponse<ClientEntity> response = ctx.getManagersEntityRequest().execute();
    final Set<RedHxUriPath> managersPathSet = new HashSet<>();

    if (response.getStatusCode() == HttpURLConnection.HTTP_OK) {
      ClientEntity entity = response.getBody();

      /**
       * get the JSON entity
       */
      ClientProperty managersProperty = entity.getProperty(JSON_MANAGERS_COLLECTION_KEYWORD);

      for (ClientValue managersValue : managersProperty.getCollectionValue()) {
        ClientComplexValue cplx = managersValue.asComplex();

        if (cplx != null) {
          ClientAnnotation anno = cplx.getAnnotations().get(0);

          if (anno.getTerm().equals(ODATA_SINGLE_MANAGERS_KEYWORD)) {
            String managersPath = anno.getValue().toString();

            if (managersPath == null) {
              throw new RedHxManagerParseException(
                  "The JSON annotation pointing to a specific managers was null.");
            }

            RedHxUriPath path = new RedHxUriPathImpl(managersPath);

            managersPathSet.add(path);
          } else {
            throw new RedHxManagerParseException(
                "Unable to find keyword " + ODATA_SINGLE_MANAGERS_KEYWORD);
          }
        } else {
          throw new RedHxManagerParseException("The JSON message did not contains a class "
              + ClientComplexValue.class.getSimpleName());
        }
      }
    } else {
      throw new RedHxHttpResponseException(RedHxServiceRootIdEum.MANAGERS, response.getStatusCode(),
          "Can not read Managers Collection.");
    }

    return managersPathSet;
  }
}
