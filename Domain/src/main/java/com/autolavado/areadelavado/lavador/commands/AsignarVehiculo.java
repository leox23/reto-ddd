package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

public class AsignarVehiculo extends Command {
    //todo ver como sera la relacion aqui, si se debe crear id independiente o si tiene relacion con el agregado cliente
    private final VehiculoId vehiculoId;
    private final VehiculosLavados vehiculosLavados;
    private final VehiculosRecibidos vehiculosRecibidos;

    public AsignarVehiculo(VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos) {
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
