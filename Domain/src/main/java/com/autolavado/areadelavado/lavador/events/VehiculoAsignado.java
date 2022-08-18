package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

public class VehiculoAsignado extends DomainEvent {
    //todo revisar todo de comaando respectivo, relacion con AR cliente
    private final VehiculoId vehiculoId;
    private final VehiculosLavados vehiculosLavados;
    private final VehiculosRecibidos vehiculosRecibidos;

    public VehiculoAsignado(VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos) {
        super("com.autolavado.areadelavado.VehiculoAsignado");
        this.vehiculoId = vehiculoId;
        this.vehiculosLavados = vehiculosLavados;
        this.vehiculosRecibidos = vehiculosRecibidos;
    }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public VehiculosLavados getVehiculosLavados() {
        return vehiculosLavados;
    }

    public VehiculosRecibidos getVehiculosRecibidos() {
        return vehiculosRecibidos;
    }
}
