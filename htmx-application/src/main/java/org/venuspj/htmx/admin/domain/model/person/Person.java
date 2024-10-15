package org.venuspj.htmx.admin.domain.model.person;

import com.google.common.base.Objects;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Table("people")
@Data
@ToString(exclude = "password")
public class Person {

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

  boolean sameIdentifierAs(Person other) {
    return this.id.equals(other.id);
  }

  public boolean sameValueAs(Person other) {
    return equals(other);

  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Person that = (Person) other;
    return Objects.equal(id, that.id) && Objects.equal(email, that.email) && Objects.equal(
        phone, that.phone) && Objects.equal(initials, that.initials) && Objects.equal(userCode,
        that.userCode) && Objects.equal(password, that.password) && Objects.equal(isHidden,
        that.isHidden) && Objects.equal(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
