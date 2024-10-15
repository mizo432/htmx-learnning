package org.venuspj.htmx.admin.infra.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import org.venuspj.htmx.admin.appl.query.people.PeopleQuery;
import org.venuspj.htmx.admin.domain.model.person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class PersonController {

  private final PeopleQuery peopleQuery;

  @GetMapping("/people")
  public Mono<Rendering> getAll() {
    Flux<Person> flux = peopleQuery.findAll();
    return Mono.just(Rendering.view("admin/people/list")
        .modelAttribute("items", new ReactiveDataDriverContextVariable(flux, 1))
        .build());
  }

  //TODO createInput
  //TODO createConfirm
  //TODO create
  //TODO updateInput
  //TODO updateConfirm
  //TODO update

}
