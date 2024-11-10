package org.venuspj.htmx.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * ControllerConfigクラスは、Spring MVCアプリケーション内のコントローラークラスに対して グローバルなバインディングを設定し、共通の機能を提供するために使用されます。
 * <p>
 * このクラスは@ControllerAdviceでアノテートされており、全てのコントローラーに対して グローバルな「アドバイス」を提供することを示しています。
 * <p>
 * initBinderメソッドは、String入力から前後の空白を削除するカスタムエディタをグローバルに登録します。
 * <p>
 * メソッド:
 * - initBinder(WebDataBinder binder): すべてのString入力から自動的に空白を削除するカスタムStringエディタを 設定します。
 */
@ControllerAdvice
public class ControllerConfig {

  /**
   * カスタムエディタを登録することで、WebDataBinderを初期化します。
   *
   * @param binder カスタムエディタを登録するために使用されるWebDataBinder。
   */
  @InitBinder
  void initBinder(final WebDataBinder binder) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }
}
