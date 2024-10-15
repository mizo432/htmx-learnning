package org.venuspj.htmx.shared.domain.type;

import lombok.NonNull;

public interface SingleValue<T, S extends SingleValue<T, S>> extends Value {

  T getValue();

  boolean sameValueAs(@NonNull S other);


}
