package org.venuspj.htmx.shared.domain.type.snowflakeId;

public class FixecNodeIdProvider extends NodeIdProvider {

  private static long NODE_ID;

  FixecNodeIdProvider(long nodeId) {
    NODE_ID = nodeId;
  }

  public static void initialize(long nodeId) {
    new NodeIdProvider(new FixecNodeIdProvider(nodeId));

  }

  @Override
  protected Long nodeId() {
    return NODE_ID;
  }

  public static void clear() {
    NodeIdProvider.clear();

  }
}
