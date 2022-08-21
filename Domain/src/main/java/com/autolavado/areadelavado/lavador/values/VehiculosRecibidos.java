package com.autolavado.areadelavado.lavador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.awt.*;
import java.util.Objects;

public class VehiculosRecibidos implements ValueObject<Integer> {
    private final Integer detalleVehiculos;

    public VehiculosRecibidos(Integer detalleVehiculos) {
        this.detalleVehiculos = Objects.requireNonNull(detalleVehiculos);
    }

    @Override
    public Integer value() {
        return detalleVehiculos;
    }

}
