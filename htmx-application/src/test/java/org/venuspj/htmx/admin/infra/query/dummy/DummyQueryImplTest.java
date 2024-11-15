package org.venuspj.htmx.admin.infra.query.dummy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.venuspj.htmx.admin.appl.query.dummy.DummyQuery;

@DisplayName("DummyQueryImplのテストクラス")
@SpringBootTest
class DummyQueryImplTest {

  @Mock
  DummyQueryImpl dummyQueryImpl;

  @InjectMocks
  DummyQueryImpl actualDummyQueryImpl;

  @Autowired
  DummyQuery actualDummyQuery;

  DummyQueryImplTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Nested
  @DisplayName("executeメソッドテストクラス")
  class ExecuteTest {

    @Test
    @DisplayName("全ての非同期メソッドが呼び出されること")
    void shouldCallAllAsyncMethods2() throws InterruptedException {

      actualDummyQuery.execute();

    }

  }
}
