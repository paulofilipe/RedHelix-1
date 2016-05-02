package org.redhelix.server.lib.manager;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.redhelix.core.manager.RedHxManager;
import org.redhelix.core.manager.RedHxManagerCollection;
import org.redhelix.core.manager.RedHxManagerCollectionImpl;
import org.redhelix.core.util.RedHxHttpResponseException;
import org.redhelix.core.util.RedHxParseException;
import org.redhelix.core.util.RedHxUriPath;
import org.redhelix.server.lib.reader.util.RedHxServerConnectionContext;

/**
 * read a collection of links to unique managers on the Redfish server. This class does not have a
 * public constructor.
 *
 * @since RedHelix Version 0.1
 * @author Hank Bruning
 */
public final class RedHxManagerCollectionReader {

  private RedHxManagerCollectionReader() {}

  /**
   * read a set of paths for managers.
   *
   * @param ctx the client connection to the Redfish Server.
   * @param managersPathSet the set of paths that point managers. This use usually provided by the
   *        service root.
   * @return a managers collection. A null is not return.
   * @throws RedHxHttpResponseException
   * @throws URISyntaxException
   * @throws RedHxParseException
   */
  public static RedHxManagerCollection readPaths(RedHxServerConnectionContext ctx,
      Set<RedHxUriPath> managersPathSet)
          throws RedHxHttpResponseException, URISyntaxException, RedHxParseException {
    final List<RedHxManager> list = new ArrayList<>();

    for (RedHxUriPath link : managersPathSet) {
      ManagerReader reader = new ManagerReader(ctx, link);
      RedHxManager managers = reader.readManager();

      if (managers != null) {
        list.add(managers);
      }
    }

    RedHxManagerCollection managersList = new RedHxManagerCollectionImpl(list);

    return managersList;
  }
}
