package org.venuspj.htmx.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * AsyncConfigurationクラスは、非同期処理を有効化し、アプリケーションに ThreadPoolTaskExecutor を提供するための設定を行います。
 */
@Configuration
@EnableAsync
@ConditionalOnProperty(
    value = "spring.thread-executor",
    havingValue = "virtual"
)
public class AsyncConfiguration {

  /**
   * 非同期タスクを処理するための ThreadPoolTaskExecutor を構成および提供します。
   *
   * <ul>
   *   <li>corePoolSize: 初期のスレッド数（新しいタスクが来たときに確保されるスレッド数）。</li>
   *   <li>queueCapacity:  キューのサイズ（タスクがキューに入れられ、スレッドが利用可能になるまで待機）。</li>
   *   <li>maxPoolSize: スレッドプールの最大数。</li>
   *   <li>threadNamePrefix: スレッド名の接頭語。</li>
   * </ul>
   *
   * @return コアプールサイズが2、キューキャパシティが2、最大プールサイズが40に設定され、 スレッド名に "AsyncTask-" がプレフィックスされる Executor。
   */
  @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
  public Executor asyncExecutor() {
    return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
  }

  @Bean
  public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
    return protocolHandler -> {
      protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    };
  }
}
