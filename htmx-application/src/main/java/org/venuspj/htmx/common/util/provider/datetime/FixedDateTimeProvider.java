package org.venuspj.htmx.common.util.provider.datetime;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;
import lombok.NonNull;

/**
 * FixedDateTimeProviderクラスは、指定された日時を提供するDateProviderのサブクラスです。
 * <p>
 * テストや特定の日時に固定する必要がある場合に使用します。
 */
public class FixedDateTimeProvider extends DateProvider {

  private static final AtomicReference<LocalDateTime> FIXED_DATE_TIME = new AtomicReference<>();

  private FixedDateTimeProvider(@NonNull LocalDateTime fixedDateTime) {
    FIXED_DATE_TIME.set(fixedDateTime);

  }

  /**
   * 指定された日時に固定するためにDateProviderを初期化します。
   *
   * @param fixedDateTime 固定する日時を指定する LocalDateTime オブジェクト
   */
  public static void initialize(@NonNull LocalDateTime fixedDateTime) {
    FixedDateTimeProvider instance = new FixedDateTimeProvider(fixedDateTime);
    new DateProvider(instance);


  }

  @Override
  protected LocalDateTime now() {
    return FIXED_DATE_TIME.get();

  }

  /**
   * DateProviderを初期化することでクリアします。
   */
  public static void clear() {
    DateProvider.clear();

  }

}
