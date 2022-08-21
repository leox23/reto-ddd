package com.autolavado.areadelavado.lavador.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.lavador.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

import java.util.Objects;

public class Vehiculos extends Entity<VehiculoId> {
    private LavadorId lavadorId;
    private VehiculoId vehiculoId;
    private VehiculosLavados vehiculosLavados;
    private VehiculosRecibidos vehiculosRecibidos;

    public Vehiculos(LavadorId lavadorId, VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos) {
        super(vehiculoId);
        this.vehiculosLavados = vehiculosLavados;
        this.vehiculosRecibidos = vehiculosRecibidos;
        this.lavadorId = lavadorId;
        this.vehiculoId = vehiculoId;
    }

    public void asignarVehiculo(LavadorId lavadorId, VehiculoId vehiculoId) {
        this.lavadorId = Objects.requireNonNull(lavadorId);
        this.vehiculoId = Objects.requireNonNull(vehiculoId);
    }

    public VehiculosLavados getVehiculosLavados() {
        return vehiculosLavados;
    }

    public VehiculosRecibidos getVehiculosRecibidos() {
        return vehiculosRecibidos;
    }

    public void asignarVehiculo(LavadorId lavadorId) {
        this.lavadorId = Objects.requireNonNull(lavadorId);
    }

}
