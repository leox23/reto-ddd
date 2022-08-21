package com.autolavado.areadelavado.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Color implements ValueObject<String> {
    private final String value;

    public Color(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color name = (Color) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
