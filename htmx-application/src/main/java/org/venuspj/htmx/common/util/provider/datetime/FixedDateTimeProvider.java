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

  /**
   * {@link LocalDateTime} をアトミックに変更できる静的な最終参照です。
   * <p>
   * この変数は {@link FixedDateTimeProvider} クラスの一部であり、固定された日時の値を保持するために使用されます。
   * これは、特定の日時の値が必要なテストシナリオで特に役立ちます。
   */
  private static final AtomicReference<LocalDateTime> FIXED_DATE_TIME = new AtomicReference<>();

  /**
   * 指定された固定日時でFixedDateTimeProviderを構築します。
   *
   * @param fixedDateTime 使用する固定日時を表すLocalDateTime。
   */
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

  /**
   * このプロバイダで指定された固定された日時を返します。
   *
   * @return このプロバイダで使用される固定された {@link LocalDateTime}
   */
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
