package org.venuspj.htmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The HtmxLearningApplication is the entry point to the Spring Boot application.
 * <p>
 * This class contains the main method which uses Spring Boot's SpringApplication.run() method to
 * launch the application.
 * <p>
 * It is annotated with @SpringBootApplication which is a convenience annotation that adds
 *
 * @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations.
 */
@EnableAsync
@SpringBootApplication
public class HtmxLearningApplication {

  /**
   * The main method which serves as the entry point for the Spring Boot application.
   *
   * @param args command-line arguments passed to the application
   */
  public static void main(String[] args) {
    SpringApplication.run(HtmxLearningApplication.class, args);
  }

}
