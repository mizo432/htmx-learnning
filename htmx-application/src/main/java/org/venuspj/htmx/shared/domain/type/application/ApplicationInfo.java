package org.venuspj.htmx.shared.domain.type.application;

import java.util.concurrent.atomic.AtomicReference;


/**
 * ApplicationInfoクラスは、アプリケーション名やサーバーポートなどのアプリケーション情報を保存および取得するために使用されます。
 */
public class ApplicationInfo {

  /**
   * {@link ApplicationInfo} のインスタンスへのスレッドセーフなシングルトン参照。
   * <p>
   * この変数は、アプリケーション名やサーバーポートなどの詳細を含む {@link ApplicationInfo} の
   * 単一のグローバルにアクセス可能なインスタンスをアプリケーションが維持することを可能にします。
   */
  private final static AtomicReference<ApplicationInfo> applicationInfo =
      new AtomicReference<>(new ApplicationInfo());

  /**
   * アプリケーションサーバーで使用されるデフォルトのポート番号。
   * <p>
   * この定数は、他のポートが指定されていない場合にサーバーがデフォルトでリッスンするポートを表します。
   */
  private static final long DEFAULT_PORT = 8080;
  /**
   * アプリケーションのデフォルト名。
   * <p>
   * 他の名前が設定されていない場合や提供されていない場合に使用されるフォールバック名です。
   */
  private static final String DEFAULT_APPLICATION_NAME = "DEFAULT_APPLICATION_NAME";

  protected ApplicationInfo() {

  }

  /**
   * 指定されたApplicationInfoインスタンスをコピーして、新しいApplicationInfoインスタンスを構築します。
   * このコンストラクタは、提供されたインスタンスをグローバルなapplicationInfo参照に設定します。
   *
   * @param applicationInfo コピーしてグローバルに設定するApplicationInfoインスタンス
   */
  public ApplicationInfo(ApplicationInfo applicationInfo) {
    ApplicationInfo.applicationInfo.set(applicationInfo);

  }

  /**
   * アプリケーションの名前を返します。
   *
   * @return アプリケーションの名前。
   */
  public static String name() {
    return ApplicationInfo.applicationInfo.get().applicationName();
  }

  /**
   * アプリケーションが使用するサーバーポートを取得します。
   *
   * @return アプリケーションサーバーが稼働しているポート番号。
   */
  public static long port() {
    return ApplicationInfo.applicationInfo.get().serverPort();
  }

  /**
   * グローバルなApplicationInfoインスタンスを新しいデフォルトの状態にリセットします。
   *
   * <p>
   * このメソッドは、アプリケーションの名前やサーバーポートなどのアプリケーションの詳細を保持する
   * グローバルにアクセス可能なAtomicReferenceに新しいApplicationInfoインスタンスを設定し、 以前に設定された詳細を効果的にクリアします。
   */
  public static void clear() {
    ApplicationInfo.applicationInfo.set(new ApplicationInfo());

  }

  /**
   * アプリケーションのデフォルト名を取得します。
   *
   * @return アプリケーションのデフォルト名。
   */
  protected String applicationName() {
    return DEFAULT_APPLICATION_NAME;
  }


  /**
   * アプリケーションサーバーが実行されているデフォルトのポート番号を返します。
   *
   * @return アプリケーションサーバーのデフォルトのポート番号。
   */
  protected long serverPort() {
    return DEFAULT_PORT;
  }

}
