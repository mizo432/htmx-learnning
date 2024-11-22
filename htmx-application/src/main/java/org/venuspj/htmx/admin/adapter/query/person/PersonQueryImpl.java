package org.venuspj.htmx.admin.adapter.query.person;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venuspj.htmx.admin.appl.query.people.PersonQuery;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonQueryImpl implements PersonQuery {

  private final PersonRepository personRepository;

  @Override
  public Iterable<Person> findAll() {
    return personRepository.findAll();

  }

  @Override
  public Optional<Person> findById(long personId) {
    return personRepository.findById(personId);

  }
}
