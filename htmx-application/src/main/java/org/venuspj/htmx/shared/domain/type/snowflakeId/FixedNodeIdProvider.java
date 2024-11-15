package org.venuspj.htmx.shared.domain.type.snowflakeId;

public class FixedNodeIdProvider extends NodeIdProvider {

  private static long NODE_ID;

  private FixedNodeIdProvider(long nodeId) {
    NODE_ID = nodeId;
  }

  public static void initialize(long nodeId) {
    new NodeIdProvider(new FixedNodeIdProvider(nodeId));

  }

  @Override
  protected Long nodeId() {
    return NODE_ID;
  }

  public static void clear() {
    NodeIdProvider.clear();

  }
}
