package org.venuspj.htmx.admin.infra.query.dummy;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.venuspj.htmx.admin.appl.query.dummy.DummyQuery;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class DummyQueryImpl implements DummyQuery {

  private final PersonRepository personRepository;

  @Override
  public void execute() {
    try {
      CompletableFuture<Iterable<Person>> future1 = executeAsync1();
      CompletableFuture<Iterable<Person>> future2 = executeAsync2();
      CompletableFuture<Iterable<Person>> future3 = executeAsync3();
      CompletableFuture<Iterable<Person>> future4 = executeAsync4();
      CompletableFuture.allOf(future1, future2, future3, future4).join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log.info("All done");

  }

  @Async
  CompletableFuture<Iterable<Person>> executeAsync1() throws InterruptedException {
    Iterable<Person> personIterable = personRepository.findAll();
    log.info("Executing async 1");
    return CompletableFuture.completedFuture(personIterable);
  }

  @Async
  CompletableFuture<Iterable<Person>> executeAsync2() throws InterruptedException {
    Iterable<Person> personIterable = personRepository.findAll();
    log.info("Executing async 2");
    return CompletableFuture.completedFuture(personIterable);
  }

  @Async
  CompletableFuture<Iterable<Person>> executeAsync3() throws InterruptedException {
    Iterable<Person> personIterable = personRepository.findAll();
    log.info("Executing async 3");
    return CompletableFuture.completedFuture(personIterable);
  }

  @Async
  CompletableFuture<Iterable<Person>> executeAsync4() throws InterruptedException {
    Iterable<Person> personIterable = personRepository.findAll();
    log.info("Executing async 4");
    return CompletableFuture.completedFuture(personIterable);
  }

}
