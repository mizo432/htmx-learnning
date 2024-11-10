package org.venuspj.htmx.admin.appl.command.person;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;

@Service
@RequiredArgsConstructor
public class DropPerson {

  private final PersonRepository personRepository;

  public void execute(long personId) {
    Optional<Person> oldPerson = personRepository.findById(
        personId);
    if (oldPerson.isEmpty()) {
      throw new IllegalStateException("削除対象のデータがありません");
    }
    Person person = oldPerson.get();

    personRepository.save(person.delete());
  }
}
