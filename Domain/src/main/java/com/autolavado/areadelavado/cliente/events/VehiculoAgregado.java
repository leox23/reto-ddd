package com.autolavado.areadelavado.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.values.Color;
import com.autolavado.areadelavado.cliente.values.TipoDeVehiculo;
import com.autolavado.areadelavado.cliente.values.VehiculoId;

public class VehiculoAgregado extends DomainEvent {
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;
    private final Color color;

    public VehiculoAgregado(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, Color color) {
        super("com.autolavado.areadelavado.VehiculoAgregado");
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
