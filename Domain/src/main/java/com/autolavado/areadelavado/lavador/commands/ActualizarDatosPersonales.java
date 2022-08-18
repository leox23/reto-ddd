package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.lavador.values.Celular;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.Nombre;

public class ActualizarDatosPersonales extends Command {
    private final LavadorId lavadorId;
    private final Nombre nombre;
    private final Celular celular;

    public ActualizarDatosPersonales(LavadorId lavadorId, Nombre nombre, Celular celular) {
        this.lavadorId = lavadorId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public LavadorId getLavadorId() {
        return lavadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
