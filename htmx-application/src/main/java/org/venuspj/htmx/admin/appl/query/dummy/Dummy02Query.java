package org.venuspj.htmx.admin.appl.query.dummy;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class Dummy02Query {

  private final PersonRepository personRepository;

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
    log.info("all done {}", Thread.currentThread());

  }

  @Async
  public CompletableFuture<Iterable<Person>> executeAsync1() throws InterruptedException {
    return CompletableFuture.supplyAsync(() -> {
      Iterable<Person> personIterable = personRepository.findAll();
      return personIterable;

    });
  }

  @Async
  public CompletableFuture<Iterable<Person>> executeAsync2() throws InterruptedException {
    return CompletableFuture.supplyAsync(() -> {
      Iterable<Person> personIterable = personRepository.findAll();
      return personIterable;

    });
  }

  @Async
  CompletableFuture<Iterable<Person>> executeAsync3() throws InterruptedException {
    return CompletableFuture.supplyAsync(() -> {
      Iterable<Person> personIterable = personRepository.findAll();
      return personIterable;

    });
  }

  @Async
  CompletableFuture<Iterable<Person>> executeAsync4() throws InterruptedException {
    return CompletableFuture.supplyAsync(() -> {
      Iterable<Person> personIterable = personRepository.findAll();
      return personIterable;

    });
  }

}
