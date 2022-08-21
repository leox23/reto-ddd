package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

public class VehiculoAsignado extends DomainEvent {
    private final LavadorId lavadorId;
    private final VehiculoId vehiculoId;
    private final VehiculosLavados vehiculosLavados;
    private final VehiculosRecibidos vehiculosRecibidos;

    public VehiculoAsignado(LavadorId lavadorId, VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos) {
        super("com.autolavado.areadelavado.VehiculoAsignado");
        this.lavadorId = lavadorId;
        this.vehiculoId = vehiculoId;
        this.vehiculosLavados = vehiculosLavados;
        this.vehiculosRecibidos = vehiculosRecibidos;
    }

    public LavadorId getLavadorId() {
        return lavadorId;
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
