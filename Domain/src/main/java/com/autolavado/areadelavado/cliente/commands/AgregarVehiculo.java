package com.autolavado.areadelavado.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.values.Color;
import com.autolavado.areadelavado.cliente.values.TipoDeVehiculo;
import com.autolavado.areadelavado.cliente.values.VehiculoId;

public class AgregarVehiculo extends Command {
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;
    private final Color color;

    public AgregarVehiculo(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, Color color) {
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
}
