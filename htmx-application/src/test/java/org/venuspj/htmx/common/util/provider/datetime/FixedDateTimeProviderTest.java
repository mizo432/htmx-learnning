package org.venuspj.htmx.common.util.provider.datetime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("FixedDateTimeProviderのテスト")
class FixedDateTimeProviderTest {

  private LocalDateTime testDateTime = LocalDateTime.of(2024, 12, 25, 12, 0);

  @AfterEach
  void tearDown() {
    FixedDateTimeProvider.clear();
  }

  @Nested
  @DisplayName("initializeメソッドのテスト")
  class InitializeMethod {

    @Test
    @DisplayName("正常なシナリオで初期化されます")
    void shouldInitializeWithValidScenarios() {
      FixedDateTimeProvider.initialize(testDateTime);

      assertThat(DateProvider.currentLocalDateTime())
          .isEqualTo(testDateTime);
    }

    @Test
    @DisplayName("nullが渡された場合、NullPointerExceptionがスローされるべき")
    void shouldThrowNullPointerExceptionWhenNullIsPassed() {
      assertThatNullPointerException()
          .isThrownBy(() -> FixedDateTimeProvider.initialize(null))
          .withMessage("fixedDateTime is marked non-null but is null");
    }
  }
}
