package org.venuspj.htmx.shared.domain.type.snowflakeId;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Objects;
import lombok.NonNull;
import org.venuspj.htmx.shared.domain.type.SingleValue;

/**
 * SnowflakeIdクラスは、Snowflakeアルゴリズムを使用して生成されたユニークな識別子を表します。
 * <p>
 * このクラスは、ユニーク識別子を表すLong値をカプセル化しています。 Snowflake IDを作成、再構築、および比較するためのメソッドを提供しています。
 */
public class SnowflakeId implements SingleValue<Long, SnowflakeId> {

  public static final SnowflakeId EMPTY = new SnowflakeId(null);

  private final Long value;

  private SnowflakeId(Long value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public Long getValue() {
    return value;
  }

  @Override
  public boolean sameValueAs(@NonNull SnowflakeId other) {
    return value.equals(other.value);

  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static SnowflakeId reconstruct(Long value) {
    if (value == null) {
      return EMPTY;
    }
    return new SnowflakeId(value);
  }

  @JsonCreator
  public static SnowflakeId of(Long value) {
    if (value == null) {
      return EMPTY;
    }
    return new SnowflakeId(value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(SnowflakeId.class, value);
  }

  public static SnowflakeId newInstance() {
    return new SnowflakeId(SnowflakeIdProvider.generateId());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnowflakeId that = (SnowflakeId) o;
    return Objects.equal(value, that.value);
  }

  @Override
  public boolean isEmpty() {
    return value == null;
  }
}
