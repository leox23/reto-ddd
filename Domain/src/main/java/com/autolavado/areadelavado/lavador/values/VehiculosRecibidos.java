package com.autolavado.areadelavado.lavador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.awt.*;
import java.util.Objects;

public class VehiculosRecibidos implements ValueObject<List> {
    private final List detalleVehiculos;

    public VehiculosRecibidos(List detalleVehiculos) {
        this.detalleVehiculos = Objects.requireNonNull(detalleVehiculos);
    }

    @Override
    public List value() {
        return null;
    }

}
