package com.autolavado.areadelavado.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HoraDeEntrega implements ValueObject<String> {
    private final String value;

    public HoraDeEntrega(String value) {
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
        HoraDeEntrega horaDeEntrega = (HoraDeEntrega) o;
        return Objects.equals(value, horaDeEntrega.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
