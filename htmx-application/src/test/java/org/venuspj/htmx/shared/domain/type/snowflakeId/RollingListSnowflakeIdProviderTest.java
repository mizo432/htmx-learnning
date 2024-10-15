package org.venuspj.htmx.shared.domain.type.snowflakeId;

import com.google.common.collect.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("RollingSnowflakeIdProviderのinitializeメソッドのテスト")
class RollingListSnowflakeIdProviderTest {

  @AfterEach
  void tearDown() {
    RollingListSnowflakeIdProvider.clear();

  }

  @Nested
  @DisplayName("引数がLong配列の場合")
  class WhenArgumentIsLongArray {


    @Test
    @DisplayName("引数がnullの場合、NullPointerExceptionがスローされる")
    void shouldThrowNullPointerExceptionWhenArgumentIsNull() {
      Assertions.assertThrows(NullPointerException.class,
          () -> RollingListSnowflakeIdProvider.initializeWithIds((Long[]) null),
          "Snowflake IDs must not be null");
    }

    @Test
    @DisplayName("引数が空の配列の場合、IllegalArgumentExceptionがスローされる")
    void shouldThrowIllegalArgumentExceptionWhenArgumentIsEmptyArray() {
      Assertions.assertThrows(IllegalArgumentException.class,
          () -> RollingListSnowflakeIdProvider.initializeWithIds(),
          "Snowflake IDs must not be empty");
    }

    @Test
    @DisplayName("正常な引数の場合、問題なく初期化できる")
    void shouldInitializeWithoutProblemsWhenArgumentsAreNormal() {
      RollingListSnowflakeIdProvider.initializeWithIds(1L, 2L, 3L);
      Assertions.assertTrue(true, "初期化成功");
    }

    @Test
    @DisplayName("引数が一つの場合、初期化が成功する")
    void shouldInitializeSuccessfullyWhenSingleArgumentIsPassed() {
      RollingListSnowflakeIdProvider.initializeWithIds(1L);
      Assertions.assertTrue(true, "初期化成功");
    }
  }

  @Nested
  @DisplayName("引数がRange<Long>の場合")
  class WhenArgumentIsRangeLong {

    @Test
    @DisplayName("正常な引数の場合、問題なく初期化できる")
    void shouldInitializeWithoutProblemsWhenArgumentsAreNormal() {
      Range<Long> range = Range.closed(1L, 10L);
      RollingListSnowflakeIdProvider.initializeWithRange(range);
      Assertions.assertTrue(true, "初期化成功");
    }

  }
}
