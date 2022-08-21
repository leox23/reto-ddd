package com.autolavado.areadelavado.cliente.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.cliente.values.Color;
import com.autolavado.areadelavado.cliente.values.TipoDeVehiculo;
import com.autolavado.areadelavado.cliente.values.VehiculoId;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoId> {
    private VehiculoId vehiculoId;
    private TipoDeVehiculo tipoDeVehiculo;
    private Color color;

    public Vehiculo(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, Color color) {
        super(vehiculoId);
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.color = color;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public Color getColor() {
        return color;
    }

    public void agregarVehiculo( TipoDeVehiculo tipoDeVehiculo, Color color){
        this.tipoDeVehiculo = Objects.requireNonNull(tipoDeVehiculo);
        this.color = Objects.requireNonNull(color);
    }
}
