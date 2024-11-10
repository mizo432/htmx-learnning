package org.venuspj.htmx.admin.appl.command.person;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venuspj.htmx.admin.domain.model.person.Person;
import org.venuspj.htmx.admin.domain.model.person.PersonRepository;
import org.venuspj.htmx.shared.domain.type.snowflakeId.SnowflakeId;


/**
 * PersonCreateクラスは新しいPersonの作成を処理する責任を持っています。
 * <p>
 * 新しいPersonを作成する前に、既存のPersonに同じユーザーコードがないことを確認します。
 * <p>
 * このクラスは非同期操作を処理するために、Reactorを使用したリアクティブプログラミングのパラダイムを採用しています。
 * Personデータをデータベースに保存するために、PersonRepositoryと連携します。 クラスに{@link Service}アノテーションが付与されており、
 * これはSpringコンテキストにおけるサービスコンポーネントであることを示しています。
 * <p>
 * このクラス内のexecuteメソッドはトランザクショナルであり、 操作全体が成功するか、エラーが発生した場合にロールバックされることを保証します。
 */
@Service
@RequiredArgsConstructor
public class CreatePerson {

  private final PersonRepository personRepository;

  /**
   * 同じユーザーコードを持つPersonがリポジトリに既に存在しない場合、新しいPersonオブジェクトの作成プロセスを実行します。
   * <p>
   * 同じユーザーコードを持つPersonが見つかり、かつ非表示でない場合は、IllegalStateExceptionがスローされます。
   * そうでなければ、新しいPerson用に一意の識別子が生成され、Personはリポジトリに保存されます。
   *
   * @param newPerson 作成する必要がある新しいPersonオブジェクト。
   * @throws IllegalStateException 同じユーザーコードを持つPersonが既に存在し、かつ非表示でない場合。
   */
  @Transactional
  public void execute(Person newPerson) {
    Optional<Person> oldPeople = personRepository.findByUserCodeAndIsHidden(newPerson.getUserCode(),
        Person.NOT_HIDDEN);
    if (oldPeople.isPresent()) {
      throw new IllegalStateException("既に同じユーザーコードを持つユーザーが存在します。");
    } else {
      SnowflakeId newPersonId = SnowflakeId.newInstance();
      newPerson.setId(newPersonId.getValue());
      personRepository.save(newPerson);
    }
  }

}
