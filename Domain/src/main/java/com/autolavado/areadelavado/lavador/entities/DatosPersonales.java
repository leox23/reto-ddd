package com.autolavado.areadelavado.lavador.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.NombreLavador;

import java.util.Objects;

public class DatosPersonales extends Entity<LavadorId> {
    private NombreLavador nombre;
    private CelularLavador celular;

    public DatosPersonales(LavadorId lavadorId, NombreLavador nombre, CelularLavador celular) {
        super(lavadorId);
        this.nombre = nombre;
        this.celular = celular;
    }

    public NombreLavador getNombreLavador() {
        return nombre;
    }

    public CelularLavador getCelularLavador() {
        return celular;
    }

    public void actualizarDatosLavador(NombreLavador nombre, CelularLavador celular) {
        this.nombre = Objects.requireNonNull(nombre);
        this.celular = Objects.requireNonNull(celular);
    }
}
