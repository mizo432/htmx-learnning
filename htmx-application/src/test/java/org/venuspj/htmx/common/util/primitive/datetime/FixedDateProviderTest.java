package org.venuspj.htmx.common.util.primitive.datetime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("StaticDateProviderクラスの")
class FixedDateProviderTest {

  void teardown() {
    FixedDateProvider.clear();
  }

  @DisplayName("initializeメソッドは")
  @Nested
  class InitializeTest {

    @DisplayName("引数にnullが渡された場合、NullPointerExceptionをスローする")
    @Test
    void shouldThrowNullPointerExceptionWhenPassedArgumentIsNull() {
      assertThatThrownBy(() -> FixedDateProvider.initialize(null))
          .as("NullPointerExceptionがスローされるべきです")
          .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("引数にLocalDateが渡された場合、正常に初期化できる")
    @Test
    void shouldInitializeWhenPassedArgumentIsLocalDate() {
      LocalDate localDate = LocalDate.now();

      FixedDateProvider.initialize(localDate);

      LocalDate actual = DateProvider.currentLocalDate();
      assertThat(actual)
          .as("初期化されたエンティティは期待されたLocalDateと等しくなければなりません")
          .isEqualTo(localDate);
    }
  }
}
