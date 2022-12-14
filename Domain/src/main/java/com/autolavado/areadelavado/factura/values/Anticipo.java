package com.autolavado.areadelavado.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Anticipo implements ValueObject<Integer> {
    private final Integer value;

    public Anticipo(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anticipo anticipo = (Anticipo) o;
        return Objects.equals(value, anticipo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
