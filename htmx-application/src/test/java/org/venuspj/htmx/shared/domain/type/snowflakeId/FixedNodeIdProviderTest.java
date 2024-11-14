package org.venuspj.htmx.shared.domain.type.snowflakeId;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("StaticNodeIdProviderクラス")
class FixedNodeIdProviderTest {

  @Nested
  @DisplayName("initializeメソッド")
  class InitializeTest {

    @Test
    @DisplayName("nodeIdが正しく設定されている場合")
    void shouldSetCorrectNodeId() {
      long nodeId = 5L;

      FixecNodeIdProvider.initialize(nodeId);

      long actualNodeId = NodeIdProvider.getNodeId();

      assertThat(actualNodeId).as("設定されたnodeIdが正しいこと").isEqualTo(nodeId);

      FixecNodeIdProvider.clear();


    }

  }

}
