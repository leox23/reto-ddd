package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.NombreLavador;

public class ActualizarDatosLavador extends Command {
    private final LavadorId lavadorId;
    private final NombreLavador nombre;
    private final CelularLavador celular;

    public ActualizarDatosLavador(LavadorId lavadorId, NombreLavador nombre, CelularLavador celular) {
        this.lavadorId = lavadorId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public LavadorId getLavadorId() {
        return lavadorId;
    }

    public NombreLavador getNombre() {
        return nombre;
    }
}
