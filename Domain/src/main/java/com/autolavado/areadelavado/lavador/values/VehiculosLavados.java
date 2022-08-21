package com.autolavado.areadelavado.lavador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.awt.*;
import java.util.Objects;

public class VehiculosLavados implements ValueObject<VehiculosLavados.Props> {
    private final List detalleVehiculo;
    private final Boolean todoCompletado;

    public VehiculosLavados(List detalleVehiculo, Boolean todoCompletado ) {
        this.detalleVehiculo = Objects.requireNonNull(detalleVehiculo);
        this.todoCompletado = Objects.requireNonNull(todoCompletado);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public List detalleVehiculo() {
                return null;
            }

            @Override
            public Boolean todoCompletado() {
                return null;
            }
        };
    }


    public interface Props {
        List detalleVehiculo();
        Boolean todoCompletado();
    }
}
