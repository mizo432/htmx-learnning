package org.venuspj.htmx.common.util.primitive.datetime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.ZoneId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DateProviderTest {

  @DisplayName("DateProviderクラスのテスト")
  @Nested
  class CurrentLocalDateTimeTest {

    @DisplayName("currentLocalDateTimeメソッドのテスト")
    @Test
    void shouldProvideStayForConfirmation() {
      LocalDateTime expectLocalDateTime = LocalDateTime.of(2024, 12, 10, 12, 22, 11);
      DateProvider dp = Mockito.spy(DateProvider.class);
      given(dp.now()).willReturn(expectLocalDateTime);
      DateProvider.setDateProvider(dp);

      LocalDateTime result = DateProvider.currentLocalDateTime();

      assertThat(result).as("提供されたLocalDateTimeが予期した物と一致するか")
          .isEqualTo(expectLocalDateTime);
    }
  }

  @DisplayName("DateProviderクラスのCurrentLocalDateメソッドのテスト")
  @Nested
  class CurrentLocalDateTest {

    @DisplayName("currentLocalDateが期待したLocalDateと一致することをテスト")
    @Test
    void shouldReturnExpectedLocalDate() {
      LocalDate expectedLocalDate = LocalDate.of(2024, 12, 10);
      LocalDateTime expectedLocalDateTime = LocalDateTime.of(2024, 12, 10, 12, 22, 11);
      DateProvider dp = Mockito.spy(DateProvider.class);
      given(dp.now()).willReturn(expectedLocalDateTime);
      DateProvider.setDateProvider(dp);

      LocalDate result = DateProvider.currentLocalDate();

      assertThat(result).as("提供されたLocalDateが予期した物と一致するか")
          .isEqualTo(expectedLocalDate);
    }

  }

  @DisplayName("DateProviderクラスのcurrentLocalTimeメソッドのテスト")
  @Nested
  class CurrentLocalTimeTest {

    @DisplayName("currentLocalTimeが期待したLocalTimeと一致することをテスト")
    @Test
    void shouldProvideExpectedLocalTime() {
      LocalDateTime expectedLocalDateTime = LocalDateTime.of(2022, 10, 11, 13, 15, 20);
      LocalTime expectedLocalTime = LocalTime.of(13, 15, 20);
      DateProvider dp = Mockito.spy(DateProvider.class);
      given(dp.now()).willReturn(expectedLocalDateTime);
      DateProvider.setDateProvider(dp);

      LocalTime result = DateProvider.currentLocalTime();

      assertThat(result).as("提供されたLocalTimeが予期した物と一致するか")
          .isEqualTo(expectedLocalTime);
    }
  }

  @DisplayName("DateProviderクラスのcurrentYearMonthメソッドのテスト")
  @Nested
  class CurrentYearMonthTest {

    @DisplayName("currentYearMonthが期待したYearMonthと一致することをテスト")
    @Test
    void shouldReturnExpectedYearMonth() {
      LocalDateTime expectedLocalDateTime = LocalDateTime.of(2024, 12, 10, 12, 22, 11);
      YearMonth expectedYearMonth = YearMonth.of(2024, 12);
      DateProvider dp = Mockito.spy(DateProvider.class);
      given(dp.now()).willReturn(expectedLocalDateTime);
      DateProvider.setDateProvider(dp);

      YearMonth result = DateProvider.currentYearMonth();

      assertThat(result).as("提供されたYearMonthが予期した物と一致するか")
          .isEqualTo(expectedYearMonth);
    }
  }

  @DisplayName("DateProviderクラスのcurrentTimeMillisメソッドのテスト")
  @Nested
  class CurrentTimeMillisTest {

    @DisplayName("currentTimeMillisが期待したtimeMillisと一致することをテスト")
    @Test
    void shouldReturnCorrectTimeMillis() {
      LocalDateTime expectedLocalDateTime = LocalDateTime.of(2024, 12, 10, 12, 22, 11);
      long expectedTimeMillis = expectedLocalDateTime.atZone(ZoneId.systemDefault()).toInstant()
          .toEpochMilli();
      DateProvider dp = Mockito.spy(DateProvider.class);
      given(dp.now()).willReturn(expectedLocalDateTime);
      DateProvider.setDateProvider(dp);

      long result = DateProvider.currentTimeMillis();

      assertThat(result).as("提供されたtimeMillisが予期した物と一致するか")
          .isEqualTo(expectedTimeMillis);
    }
  }

  @DisplayName("DateProviderクラスのcurrentMonthDayメソッドのテスト")
  @Nested
  class CurrentMonthDayTest {

    @DisplayName("currentMonthDayで期待したMonthDayと一致することをテスト")
    @Test
    void shouldReturnExpectedMonthDay() {
      LocalDateTime expectedLocalDateTime = LocalDateTime.of(2023, 12, 10, 13, 43, 21);
      MonthDay expectedMonthDay = MonthDay.of(12, 10);
      DateProvider dp = Mockito.spy(DateProvider.class);
      given(dp.now()).willReturn(expectedLocalDateTime);
      DateProvider.setDateProvider(dp);

      MonthDay result = DateProvider.currentMonthDay();

      assertThat(result).as("提供されたMonthDayが予期した物と一致するか")
          .isEqualTo(expectedMonthDay);
    }
  }
}
