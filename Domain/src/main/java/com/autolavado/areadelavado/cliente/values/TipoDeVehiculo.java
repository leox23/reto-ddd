package com.autolavado.areadelavado.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeVehiculo implements ValueObject<String> {
    private final String value;

    public TipoDeVehiculo(String value) {
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
        TipoDeVehiculo tipoDeVehiculo = (TipoDeVehiculo) o;
        return Objects.equals(value, tipoDeVehiculo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
