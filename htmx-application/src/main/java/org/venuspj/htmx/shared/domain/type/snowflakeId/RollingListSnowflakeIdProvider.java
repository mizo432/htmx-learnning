package org.venuspj.htmx.shared.domain.type.snowflakeId;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lombok.NonNull;

/**
 * RollingListSnowflakeIdProviderは、Snowflakeアルゴリズムに基づいてユニークなIDを生成するSnowflakeIdProviderのサブクラスです。
 * <p>
 * ユニークなIDを生成するために、Snowflake IDのローリングリストを維持します。
 */
public class RollingListSnowflakeIdProvider extends SnowflakeIdProvider {

  private static final String ILLEGAL_ARGUMENT_MESSAGE = "Snowflake IDs must not be empty";
  private final List<Long> idList = new ArrayList<>();
  private int currentIndex;

  private RollingListSnowflakeIdProvider(Collection<Long> idList) {
    this.idList.addAll(idList);
    currentIndex = 0;
  }

  public static void initializeWithIds(@NonNull Long... snowflakeIds) {
    if (snowflakeIds.length == 0) {
      throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
    }
    new SnowflakeIdProvider(
        new RollingListSnowflakeIdProvider(Arrays.asList(snowflakeIds)));
  }

  public static void initializeWithRange(@NonNull Range<Long> snowflakeIdRange) {
    checkArgument(!snowflakeIdRange.isEmpty(), "snowflakeIdRange must not be empty");

    long fromValue = InitialValueExtractor.extractLowerValue(snowflakeIdRange);
    long toValue = InitialValueExtractor.extractUpperValue(snowflakeIdRange);

    List<Long> snowflakeIds = newArrayList();
    for (long snowflakeId = fromValue; snowflakeId <= toValue; snowflakeId++) {
      snowflakeIds.add(snowflakeId);
    }

    new SnowflakeIdProvider(
        new RollingListSnowflakeIdProvider(snowflakeIds));
  }

  /**
   * Snowflakeアルゴリズムに基づいて一意のIDを生成します。
   *
   * @return 生成された一意のID。
   * @throws RuntimeException 時計が後ろ向きに動く場合。
   */
  @Override
  protected synchronized long snowflakeId() {
    Long result = idList.get(currentIndex);
    currentIndex = (currentIndex + 1) % idList.size();
    return result;
  }

  /**
   * このメソッドは、lastTimestamp変数を-62167252739000Lに初期化します。
   */
  public static void clear() {
    SnowflakeIdProvider.clear();
  }
}

class InitialValueExtractor {

  static long extractLowerValue(Range<Long> range) {
    return (range.lowerBoundType() == BoundType.CLOSED) ? range.lowerEndpoint()
        : range.lowerEndpoint() + 1;
  }

  static long extractUpperValue(Range<Long> range) {
    return (range.upperBoundType() == BoundType.CLOSED) ? range.upperEndpoint()
        : range.upperEndpoint() - 1;
  }
}
