package org.venuspj.htmx.shared.domain.type.snowflakeId;

import lombok.NonNull;

/**
 * FixedSnowflakeIdProviderクラスは、固定のSnowflake IDを提供するために使用されます。
 * <p>
 * このクラスはSnowflakeIdProviderを拡張し、常に固定値を返すようにオーバーライドされたメソッドを提供します。
 */
public final class FixedSnowflakeIdProvider extends SnowflakeIdProvider {

  private final Long fixedValue;

  private FixedSnowflakeIdProvider(@NonNull Long fixedValue) {
    this.fixedValue = fixedValue;
  }

  /**
   * Snowflake IDプロバイダーを固定のSnowflake IDを持つFixedSnowflakeIdProviderに設定します。
   *
   * @param snowflakeId FixedSnowflakeIdProviderが使用する固定Snowflake ID（null不可）
   */
  public static void initialize(@NonNull Long snowflakeId) {
    SnowflakeIdProvider.setSnowflakeIdProvider(new FixedSnowflakeIdProvider(snowflakeId));

  }

  /**
   * Snowflakeアルゴリズムに基づいて一意のIDを生成します。
   *
   * @return 生成された一意のID。
   * @throws RuntimeException 時計が後ろ向きに動く場合。
   */
  @Override
  protected synchronized long snowflakeId() {
    return fixedValue;

  }

  /**
   * このメソッドは、lastTimestamp変数を-62167252739000Lに初期化します。
   */
  public static void clear() {
    SnowflakeIdProvider.clear();

  }
}
