package org.venuspj.htmx.shared.domain.type.snowflakeId;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FixedSnowflakeIdProviderTest {

  @Nested
  @DisplayName("initializeメソッドをテストする")
  class WhenInitialize {

    @Test
    @DisplayName("値がnullの場合、NullPointerExceptionがスローされる")
    void shouldThrowNullPointerExceptionWhenNull() {
      assertThatThrownBy(() -> FixedSnowflakeIdProvider.initialize(null))
          .isInstanceOf(NullPointerException.class)
          .hasMessageContaining("snowflakeId is marked non-null but is null");
    }

    @Test
    @DisplayName("正常な値の場合、エラーはスローされない")
    void shouldNotThrowAnyExceptionWhenNotNull() {
      assertThatCode(() -> FixedSnowflakeIdProvider.initialize(1234567890L))
          .doesNotThrowAnyException();
    }
  }
}
