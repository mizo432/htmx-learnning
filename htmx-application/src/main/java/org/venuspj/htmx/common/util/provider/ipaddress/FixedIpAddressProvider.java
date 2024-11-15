package org.venuspj.htmx.common.util.provider.ipaddress;

import java.util.concurrent.atomic.AtomicReference;
import lombok.NonNull;

/**
 * ネットワーク接続のための静的IPアドレスを提供するクラス。
 *
 * <p>このクラスは、ホストシステムのIPアドレスを取得する責任を持つ {@link IpAddressProvider} クラスを拡張します。 このクラスによって提供される IP
 * アドレスは静的であり、ランタイム中に変更されません。</p>
 *
 * <p>IPアドレスは、一貫性を保証し、IPアドレスへのアクセスや更新時に競合状態を防ぐために、{@link AtomicReference}
 * を使用してスレッドセーフな方法で保存されます。</p>
 *
 * <p>このクラスのインスタンスは、希望の静的IPアドレスを使用してコンストラクタで作成されます。 作成されると、{@link #ipHostAddress()}
 * メソッドを通じてIPアドレスにアクセスできます。</p>
 *
 * <p>静的IPアドレスをネットワーク操作で使用可能にするためには、{@link #initialize(String)} メソッドを呼び出す必要があります。 このメソッドは
 * {@link FixedIpAddressProvider} クラスの新しいインスタンスを作成し、静的IPアドレスを渡します。 この新しいインスタンスは、既存の
 * {@link IpAddressProvider} インスタンスを初期化するために使用されます。</p>
 *
 * <p>このクラスはネットワークスタックの初期化やシャットダウンの管理を担当するわけではなく、ネットワーク接続のための静的IPアドレスだけを提供します。</p>
 */
public class FixedIpAddressProvider extends IpAddressProvider {

  private static final AtomicReference<String> IP_ADDRESS = new AtomicReference<>();

  private FixedIpAddressProvider(@NonNull String ipAddress) {
    IP_ADDRESS.set(ipAddress);
  }

  /**
   * 与えられたIPアドレスでStaticIpAddressProviderを初期化します。
   * <p>
   * このメソッドは、与えられたIPアドレスでStaticIpAddressProviderクラスの新しいインスタンスを作成し、
   * それをIpAddressProviderクラスの新しいインスタンスに渡して初期化します。
   *
   * @param ipAddress StaticIpAddressProviderを初期化するためのIPアドレス
   */
  public static void initialize(@NonNull String ipAddress) {
    FixedIpAddressProvider instance = new FixedIpAddressProvider(ipAddress);
    new IpAddressProvider(instance);
  }

  @Override
  protected String ipHostAddress() {
    return IP_ADDRESS.get();

  }

  /**
   * 現在のIPアドレスプロバイダーをクリア(消去)する。
   */
  public static void clear() {
    IpAddressProvider.clear();

  }
}
