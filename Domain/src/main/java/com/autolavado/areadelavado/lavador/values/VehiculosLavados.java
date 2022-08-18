package com.autolavado.areadelavado.lavador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class VehiculosLavados implements ValueObject<VehiculosLavados.Props> {
    private final String detalleVehiculo;
    private final String novedad;

    public VehiculosLavados(String detalleVehiculo, String novedad) {
        this.detalleVehiculo = Objects.requireNonNull(detalleVehiculo);
        this.novedad = Objects.requireNonNull(novedad);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String detalleVehiculo() {
                return null;
            }

            @Override
            public String novedad() {
                return null;
            }
        };
    }


    public interface Props {
        String detalleVehiculo();
        String novedad();
    }
}
