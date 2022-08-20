package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

public class AsignarVehiculo extends Command {

    private final LavadorId lavadorId;
    private final VehiculoId vehiculoId;
    private final VehiculosLavados vehiculosLavados;
    private final VehiculosRecibidos vehiculosRecibidos;

    public AsignarVehiculo(LavadorId lavadorId, VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos) {
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
