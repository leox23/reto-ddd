package com.autolavado.areadelavado.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DiaDeEntrega implements ValueObject<String> {
    private final String value;

    public DiaDeEntrega(String value) {
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
        DiaDeEntrega diaDeEntrega = (DiaDeEntrega) o;
        return Objects.equals(value, diaDeEntrega.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
