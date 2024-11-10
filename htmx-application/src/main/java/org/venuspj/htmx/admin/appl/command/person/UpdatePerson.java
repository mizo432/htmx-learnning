package org.venuspj.htmx.admin.appl.command.person;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;

@Service
@RequiredArgsConstructor
public class UpdatePerson {

  private final PersonRepository personRepository;

  public void execute(Person person) {
    Optional<Person> oldPerson = personRepository.findById(person.getId());
    if (oldPerson.isEmpty()) {
      throw new IllegalStateException("更新対象のデータがありません");
    }
    personRepository.save(person);

  }
}
