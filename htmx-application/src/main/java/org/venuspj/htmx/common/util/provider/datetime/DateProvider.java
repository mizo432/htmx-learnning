package org.venuspj.htmx.common.util.provider.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicReference;

/**
 * DateProviderクラスは現在の日付と時刻を提供する役割を担っています。
 */
public class DateProvider {

  private static final AtomicReference<DateProvider> DATE_PROVIDER = new AtomicReference<>(
      new DateProvider());

  /**
   * DateProvider クラスのデフォルトのコンストラクタです。
   * <p>
   * このコンストラクタは、インスタンスの初期化時に使用され、外部から直接呼び出されることを想定していません。 出来立てのインスタンスはシングルトンパターンで管理される DateProvider
   * のデフォルト設定になります。
   */
  DateProvider() {

  }

  protected DateProvider(DateProvider dateProvider) {
    DATE_PROVIDER.set(dateProvider);

  }

  /**
   * 現在の日付と時刻を取得するための DateProvider を設定します。
   *
   * @param dateProvider 設定する DateProvider
   */
  public static void setDateProvider(DateProvider dateProvider) {
    DATE_PROVIDER.set(dateProvider);
  }

  /**
   * DateProviderオブジェクトを初期化します。
   * <p>
   * このメソッドは、新しいDateProviderのインスタンスで現在の日付プロバイダを設定します。
   */
  protected static void initialize() {
    DATE_PROVIDER.set(new DateProvider());

  }

  /**
   * 現在のLocalDateTimeを返します。
   *
   * @return 現在のLocalDateTime
   */
  public static LocalDateTime currentLocalDateTime() {
    return DATE_PROVIDER.get().now();
  }

  /**
   * 現在のローカル日付を返します。
   *
   * @return 現在のローカル日付
   */
  public static LocalDate currentLocalDate() {
    return LocalDate.from(currentLocalDateTime());

  }

  /**
   * 現在のローカル時間を返します。
   *
   * @return 現在のローカル時間
   */
  public static LocalTime currentLocalTime() {
    return LocalTime.from(currentLocalDateTime());

  }

  /**
   * 現在の年と月をYearMonthオブジェクトとして返します。
   *
   * @return 現在の年と月
   */
  public static YearMonth currentYearMonth() {
    LocalDateTime currentDateTime = currentLocalDateTime();
    return YearMonth.from(currentDateTime);
  }

  /**
   * エポックからの現在の時間をミリ秒で返します。
   *
   * @return 現在の時間（ミリ秒）
   */
  public static long currentTimeMillis() {
    LocalDateTime currentLocalDateTime = currentLocalDateTime();
    Instant instant = currentLocalDateTime.atZone(ZoneId.systemDefault()).toInstant();
    return instant.toEpochMilli();

  }

  /**
   * 現在の DateProvider インスタンスを初期化し、デフォルトの状態にリセットします。
   * <p>
   * このメソッドは DateProvider のインスタンスを新しく生成し、現在のインスタンスとして設定します。
   */
  public static void clear() {
    DateProvider.initialize();

  }

  /**
   * 現在の月と日を MonthDay オブジェクトとして取得します。
   *
   * @return 現在の月と日を表す MonthDay オブジェクト。
   */
  public static MonthDay currentMonthDay() {
    return MonthDay.from(currentLocalDateTime());
  }

  /**
   * 現在の日付と時刻を返します。
   *
   * @return 現在のLocalDateTimeオブジェクト
   */
  protected LocalDateTime now() {
    return LocalDateTime.now();

  }

}
