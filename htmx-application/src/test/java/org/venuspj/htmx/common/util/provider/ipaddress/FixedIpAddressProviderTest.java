package org.venuspj.htmx.common.util.provider.ipaddress;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FixedIpAddressProviderTest {

  @Nested
  @DisplayName("initializeメソッドのテスト")
  class InitializeTest {

    @Test
    @DisplayName("正常系 : 適切なIPアドレスが与えられた場合")
    void shouldInitializeSuccessfullyWhenValidIpProvided() {
      // Arrange
      String ipAddress = "192.168.1.1";

      // Act
      FixedIpAddressProvider.initialize(ipAddress);

      //created a new instance of StaticIpAddressProvider to get the stored ip address
      String actual = new FixedIpAddressProvider(ipAddress).ipHostAddress();

      // Assert
      assertThat(actual)
          .withFailMessage("Expected the ip address to be %s but it was %s", ipAddress, actual)
          .isEqualTo(ipAddress);

    }

    @AfterEach
    void tearDown() {
      IpAddressProvider.clear(); // Clearing the state after every test
    }
  }
}
