package com.autolavado.areadelavado.lavador.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.lavador.values.Celular;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.Nombre;

public class DatosPersonales extends Entity<LavadorId> {
    private Nombre nombre;
    private Celular celular;

    public DatosPersonales(LavadorId lavadorId, Nombre nombre, Celular celular) {
        super(lavadorId);
        this.nombre = nombre;
        this.celular = celular;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }
}
