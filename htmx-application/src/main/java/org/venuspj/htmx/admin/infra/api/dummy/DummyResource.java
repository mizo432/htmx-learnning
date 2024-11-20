package org.venuspj.htmx.admin.infra.api.dummy;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.venuspj.htmx.admin.appl.query.dummy.Dummy02Query;
import org.venuspj.htmx.admin.appl.query.dummy.DummyQuery;

@RestController
@RequestMapping("/api/dummies")
@AllArgsConstructor
public class DummyResource {

  private final DummyQuery dummyQuery;

  private final Dummy02Query dummy02Query;

  @GetMapping
  public void execute() throws InterruptedException {
    dummyQuery.execute();
  }

  @GetMapping(path = "/02")
  public void execute2() throws InterruptedException {
    dummy02Query.execute();

  }

}
