package org.venuspj.htmx.shared.domain.type.snowflakeId;

/**
 * 固定ノードIDを使用する特化されたNodeIdProvider。
 * <p>
 * このクラスは、一度初期化されるとノードIDが一定のままになることを保証します。
 */
public class FixedNodeIdProvider extends NodeIdProvider {

  /**
   * システム内のノードに対する一意の識別子を表します。
   * <p>
   * この識別子は最初に生成され、アプリケーションのライフサイクル全体で一貫して保持されるため、 他のノードと確実に識別して区別することができます。
   */
  private static long NODE_ID;

  /**
   * 指定されたノードIDでFixedNodeIdProviderを構築します。
   * <p>
   * このプロバイダは、初期化後にノードIDが一定であることを保証します。
   *
   * @param nodeId システム内のノードの一意識別子
   */
  private FixedNodeIdProvider(long nodeId) {
    NODE_ID = nodeId;
  }

  /**
   * 固定されたノードIDでNodeIdProviderを初期化します。
   * <p>
   * このメソッドは提供されたノードIDを使用して新しいNodeIdProviderインスタンスをセットアップし、 アプリケーションのライフサイクル全体でノードIDが一定であることを保証します。
   *
   * @param nodeId システム内のノードの一意の識別子
   */
  public static void initialize(long nodeId) {
    new NodeIdProvider(new FixedNodeIdProvider(nodeId));

  }

  /**
   * 固定されたノード識別子を取得します。
   *
   * @return Long値で表される固定ノードID。
   */
  @Override
  protected Long nodeId() {
    return NODE_ID;
  }

  /**
   * 現在のNodeIdProviderインスタンスをクリアし、初期化や参照をリセットします。
   * <p>
   * このメソッドは、クリア操作をNodeIdProviderクラスに委譲します。
   */
  public static void clear() {
    NodeIdProvider.clear();

  }
}
