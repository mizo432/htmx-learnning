package org.venuspj.htmx.shared.domain.type.snowflakeId;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SnowflakeIdTest {

  @DisplayName("newInstance メソッドのテスト")
  @Nested
  class NewInstanceTests {

    @DisplayName("should 新しいインスタンスが生成される")
    @Test
    void shouldReturnNewInstance() {
      SnowflakeId firstInstance = SnowflakeId.newInstance();
      SnowflakeId secondInstance = SnowflakeId.newInstance();
      assertThat(firstInstance).isNotEqualTo(secondInstance);
    }

    @DisplayName("should 新しいインスタンスが空でない")
    @Test
    void shouldReturnInstanceNotEmpty() {
      assertThat(SnowflakeId.newInstance().isEmpty()).isFalse();
    }

    @DisplayName("should 新しいインスタンスがnullでない")
    @Test
    void shouldReturnNotNullInstance() {
      assertThat(SnowflakeId.newInstance()).isNotNull();

    }
  }
}
