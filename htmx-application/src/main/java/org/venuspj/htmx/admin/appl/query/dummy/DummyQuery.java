package org.venuspj.htmx.admin.appl.query.dummy;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.venuspj.htmx.admin.domain.model.person.Person;

public interface DummyQuery {

  void execute();

  @Async
  CompletableFuture<Iterable<Person>> executeAsync1() throws InterruptedException;

  @Async
  CompletableFuture<Iterable<Person>> executeAsync2() throws InterruptedException;
}
