package com.autolavado.areadelavado.lavador.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.cliente.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

public class VehiculosAsignados extends Entity<VehiculoId> {
    private VehiculosLavados vehiculosLavados;
    private VehiculosRecibidos vehiculosRecibidos;

    public VehiculosAsignados(VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos) {
        super(vehiculoId);
        this.vehiculosLavados = vehiculosLavados;
        this.vehiculosRecibidos = vehiculosRecibidos;
    }



    public VehiculosLavados getVehiculosLavados() {
        return vehiculosLavados;
    }

    public VehiculosRecibidos getVehiculosRecibidos() {
        return vehiculosRecibidos;
    }
}
