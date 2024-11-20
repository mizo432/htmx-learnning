package org.venuspj.htmx.admin.domain.model.person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "people")
@Getter
@Setter
@ToString(exclude = "password")
public class Person {

  public static final boolean NOT_HIDDEN = false;
  @Id
  private Long id;
  private String email;
  private String phone;
  private String initials;
  private String userCode;
  private String password;
  private Boolean isHidden;
  private String name;

  public Person(@NonNull Long id,
      @NonNull String email,
      @NonNull String phone,
      @NonNull String initials,
      @NonNull String userCode,
      @NonNull String password,
      @NonNull Boolean isHidden,
      @NonNull String name) {
    this.id = id;
    this.email = email;
    this.phone = phone;
    this.initials = initials;
    this.userCode = userCode;
    this.password = password;
    this.isHidden = isHidden;
    this.name = name;

  }

  public Person() {
  }

  public static Person reconstruct(@NonNull Long id,
      @NonNull String email,
      @NonNull String phone,
      @NonNull String initials,
      @NonNull String userId,
      @NonNull String password,
      @NonNull Boolean isHidden,
      @NonNull String name) {
    return new Person(id, email, phone, initials, userId, password, isHidden, name);
  }

  public static Person newInstance() {
    return new Person();
  }

  boolean sameIdentifierAs(Person other) {
    return this.id.equals(other.id);
  }

  public boolean sameValueAs(Person other) {
    return equals(other);

  }

  public Person updateEntity(Long personId) {
    return new Person(personId, email, phone, initials, userCode, password, isHidden, name);

  }

  public Person delete() {
    return new Person(id, email, phone, initials, userCode, password, true, name);
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass = o instanceof HibernateProxy
        ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
        : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy
        ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    Person person = (Person) o;
    return getId() != null && Objects.equals(getId(), person.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }
}
