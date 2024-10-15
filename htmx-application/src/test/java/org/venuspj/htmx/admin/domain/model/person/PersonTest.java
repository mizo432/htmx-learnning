package org.venuspj.htmx.admin.domain.model.person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Nested
  class ReconstructTest {

    @Test
    @DisplayName("全てのパラメーターが適切に設定されている場合、Personオブジェクトを生成する")
    void shouldReturnPersonWhenAllParametersAreSetCorrectly() {
      Person reconstructedPerson = Person.reconstruct(
          1L,
          "test.email@test.com",
          "9999999999",
          "TI",
          "user01",
          "pass01",
          false,
          "AI Assistant"
      );
      System.out.println(reconstructedPerson);
      assertThat(reconstructedPerson.getId()).isEqualTo(1L);
      assertThat(reconstructedPerson.getEmail()).isEqualTo("test.email@test.com");
      assertThat(reconstructedPerson.getPhone()).isEqualTo("9999999999");
      assertThat(reconstructedPerson.getInitials()).isEqualTo("TI");
      assertThat(reconstructedPerson.getUserCode()).isEqualTo("user01");
      assertThat(reconstructedPerson.getPassword()).isEqualTo("pass01");
      assertThat(reconstructedPerson.getIsHidden()).isFalse();
      assertThat(reconstructedPerson.getName()).isEqualTo("AI Assistant");
    }

    @Test
    @DisplayName("idがnullの場合、例外がスローされる")
    void shouldThrowExceptionWhenIdIsNull() {
      assertThatThrownBy(() -> Person.reconstruct(
          null,
          "test.email@test.com",
          "9999999999",
          "TI",
          "user01",
          "pass01",
          false,
          "AI Assistant"
      )).isInstanceOf(NullPointerException.class);
    }

    // Similar tests can be written for each parameter
  }

  @Nested
  class EqualsTest {

    @Test
    @DisplayName("全てのパラメーターが同じオブジェクトを比較すると、同じと評価される")
    void shouldReturnTrueWhenAllParametersAreEqual() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");

      assertThat(person1).isEqualTo(person2);
      assertThat(person1).hasSameHashCodeAs(person2);
    }

    @Test
    @DisplayName("異なるパラメータを持つオブジェクトを比較すると、異なると評価される")
    void shouldReturnFalseWhenAnyParameterIsDifferent() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = new Person(2L, "different.email@test.com", "0000000000", "DIFF", "diffId",
          "diffPass", true, "DifferentAssistant");

      assertThat(person1).isNotEqualTo(person2);
      assertThat(person1).doesNotHaveSameHashCodeAs(person2);
    }

    @Test
    @DisplayName("パラメータがnullのオブジェクトを比較すると、異なると評価される")
    void shouldReturnFalseWhenComparedWithNull() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = null;

      assertThat(person1).isNotEqualTo(person2);
    }
  }

  @Nested
  class SameIdentifierAsTest {

    @Test
    @DisplayName("同じ識別子を持つPersonオブジェクトを比較するとtrueを返す")
    void shouldReturnTrueWhenIdentifiersAreSame() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = new Person(1L, "another.email@test.com", "8888888888", "AI", "user02",
          "pass02", true, "Another Assistant");

      assertThat(person1.sameIdentifierAs(person2)).isTrue();
    }

    @Test
    @DisplayName("異なる識別子を持つPersonオブジェクトを比較するとfalseを返す")
    void shouldReturnFalseWhenIdentifiersAreDifferent() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = new Person(2L, "another.email@test.com", "8888888888", "AI", "user02",
          "pass02", true, "Another Assistant");

      assertThat(person1.sameIdentifierAs(person2)).isFalse();
    }

  }

  @Nested
  class SameValueAsTest {

    @Test
    @DisplayName("全てのパラメーターが同じオブジェクトを比較すると、同じと評価される")
    void shouldReturnTrueWhenAllParametersAreEqual() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");

      assertThat(person1.sameValueAs(person2)).isTrue();
    }

    @Test
    @DisplayName("異なるパラメータを持つオブジェクトを比較すると、異なると評価される")
    void shouldReturnFalseWhenAnyParameterIsDifferent() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = new Person(2L, "different.email@test.com", "0000000000", "DIFF", "diffId",
          "diffPass", true, "DifferentAssistant");

      assertThat(person1.sameValueAs(person2)).isFalse();
    }

    @Test
    @DisplayName("パラメータがnullのオブジェクトを比較すると、異なると評価される")
    void shouldReturnFalseWhenComparedWithNull() {
      Person person1 = new Person(1L, "test.email@test.com", "9999999999", "TI", "user01", "pass01",
          false, "AI Assistant");
      Person person2 = null;

      assertThat(person1.sameValueAs(person2)).isFalse();
    }
  }
}
