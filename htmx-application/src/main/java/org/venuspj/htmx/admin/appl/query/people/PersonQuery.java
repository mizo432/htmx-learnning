package org.venuspj.htmx.admin.appl.query.people;

import java.util.Optional;
import org.venuspj.htmx.admin.domain.model.person.Person;

public interface PersonQuery {

  /**
   * データストアからすべての人物を取得します。
   *
   * @return データストアにあるすべての人物オブジェクトを発行するFlux。
   */
  Iterable<Person> findAll();

  /**
   * ユニーク識別子を使用してPersonを見つけます。
   *
   * @param personId 取得するPersonのユニークID。
   * @return 取得したPersonをエミットするMono、または指定されたIDに対応するPersonが見つからない場合はempty。
   */
  Optional<Person> findById(long personId);
  
}
