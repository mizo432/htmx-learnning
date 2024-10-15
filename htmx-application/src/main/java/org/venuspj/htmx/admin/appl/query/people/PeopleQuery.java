package org.venuspj.htmx.admin.appl.query.people;

import org.venuspj.htmx.admin.domain.model.person.Person;
import reactor.core.publisher.Flux;

public interface PeopleQuery {

  Flux<Person> findAll();
}
