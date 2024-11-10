package org.venuspj.htmx.admin.domain.model.person;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PersonRepository は R2DBC (Reactive Relational Database Connectivity) を利用して Person
 * エンティティを管理するためのインターフェースです。
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {


  /**
   * 指定されたユーザーコードと表示状態で非公開ではないPersonエンティティを取得します。
   *
   * @param userCode ユーザーを表す一意のコード。
   * @param notHidden ユーザーの表示状態（falseはユーザーが非表示ではないことを示します）。
   * @return 見つかった場合はPersonエンティティを含むOptional、それ以外は空のOptional。
   */
  Optional<Person> findByUserCodeAndIsHidden(String userCode, boolean notHidden);

}
