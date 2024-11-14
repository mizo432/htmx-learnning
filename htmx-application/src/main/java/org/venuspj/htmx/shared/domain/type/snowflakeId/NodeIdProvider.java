package org.venuspj.htmx.shared.domain.type.snowflakeId;

import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.venuspj.htmx.common.util.provider.ipaddress.IpAddressProvider;
import org.venuspj.htmx.shared.domain.type.application.ApplicationInfo;

/**
 *
 */
public class NodeIdProvider {

  private final static AtomicReference<NodeIdProvider> NODE_ID_PROVIDER =
      new AtomicReference<>(new NodeIdProvider());

  private Long nodeId;

  NodeIdProvider() {
    nodeId = null;
    try {
      String hostName = IpAddressProvider.ipAddress();
      String applicationName = ApplicationInfo.name();
      Long serverPort = ApplicationInfo.port();
      nodeId = Math.abs((long) Objects.hash(hostName, applicationName, serverPort));
    } catch (UnknownHostException e) {
      nodeId = (long) (Math.random() * (Math.pow(2, 10) - 1));
    }
    nodeId = nodeId & 1023;

  }


  protected Long nodeId() {
    return nodeId;
  }

  public static Long getNodeId() {
    return NodeIdProvider.NODE_ID_PROVIDER.get().nodeId();
  }


  protected NodeIdProvider(NodeIdProvider nodeIdProvider) {
    NODE_ID_PROVIDER.set(nodeIdProvider);
  }

  /**
   * DateProviderを初期化する
   */
  public static void clear() {
    IpAddressProvider.clear();
    ApplicationInfo.clear();
    NODE_ID_PROVIDER.set(new NodeIdProvider());

  }

}
