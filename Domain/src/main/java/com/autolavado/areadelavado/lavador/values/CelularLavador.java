package com.autolavado.areadelavado.lavador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CelularLavador implements ValueObject<String> {
    private final String value;

    public CelularLavador(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CelularLavador celularLavador = (CelularLavador) o;
        return Objects.equals(value, celularLavador.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
