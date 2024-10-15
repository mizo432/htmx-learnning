package org.venuspj.htmx.admin.infra.query.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venuspj.htmx.admin.appl.query.people.PeopleQuery;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;
import reactor.core.publisher.Flux;

@Service
@Transactional
@RequiredArgsConstructor
public class PeopleQueryImpl implements PeopleQuery {

  private final PersonRepository personRepository;

  @Override
  public Flux<Person> findAll() {
    return personRepository.findAll();
    
  }
}
