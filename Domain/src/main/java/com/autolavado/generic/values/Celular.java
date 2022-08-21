package com.autolavado.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Celular implements ValueObject<String> {

    private final String value;

    public Celular(String value) {
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
        Celular celular = (Celular) o;
        return Objects.equals(value, celular.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
