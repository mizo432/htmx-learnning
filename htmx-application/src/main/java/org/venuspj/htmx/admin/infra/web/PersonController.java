package org.venuspj.htmx.admin.infra.web;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.venuspj.htmx.admin.appl.command.person.CreatePerson;
import org.venuspj.htmx.admin.appl.command.person.DropPerson;
import org.venuspj.htmx.admin.appl.command.person.UpdatePerson;
import org.venuspj.htmx.admin.appl.query.people.PersonQuery;
import org.venuspj.htmx.admin.domain.model.person.Person;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class PersonController {

  private final PersonQuery personQuery;
  private final CreatePerson createPerson;
  private final UpdatePerson updatePerson;
  private final DropPerson dropPerson;

  /**
   * すべての人のリストを取得するためのHTTP GETリクエストを処理します。
   *
   * @return リアクティブなデータドライバコンテキスト変数を持つビューのテンプレートを初期化するMonoを返します。
   */
  @GetMapping("/people")
  public String getAll(Model model) {
    Iterable<Person> people = personQuery.findAll();
    model.addAttribute("items", people);
    return "admin/people/list";

  }

  /**
   * Handles HTTP GET request to create a new form for adding a person. Initializes a view template
   * with a new instance of Person.
   *
   * @return a Mono that emits the rendering of the create form view with a Person attribute.
   */
  @GetMapping("/people/createForm")
  public String createForm(Model model) {
    Person person = Person.newInstance();
    model.addAttribute("person", person);
    return "admin/people/createForm";

  }

  @PostMapping("/people/create")
  public String create(Person person, ModelAndView modelAndView) {
    createPerson.execute(person);
    return "redirect:/admin/people";

  }

  @GetMapping("/people/updateForm")
  public String updateForm(Model model) {
    Optional<Person> person = personQuery.findById(1L);
    model.addAttribute("person", person);
    return "admin/people/updateForm";

  }

  @PostMapping("/people/update/{personId}")
  public String update(Long personId, Person person, ModelAndView modelAndView) {
    updatePerson.execute(person.updateEntity(personId));
    return "redirect:/admin/people";
  }

  @PostMapping("/people/delete/{personId}")
  public String delete(Long personId) {
    dropPerson.execute(personId);
    return "redirect:/admin/people";

  }

}
