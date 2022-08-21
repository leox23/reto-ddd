package com.autolavado.areadelavado.factura.values;

import co.com.sofka.domain.generic.Identity;

import java.util.Objects;

public class FacturaId extends Identity {

    private final String value;

    public FacturaId(String value) {
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
        FacturaId facturaId = (FacturaId) o;
        return Objects.equals(value, facturaId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
