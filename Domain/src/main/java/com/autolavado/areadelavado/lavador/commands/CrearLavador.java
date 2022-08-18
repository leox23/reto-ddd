package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;
import com.autolavado.areadelavado.lavador.values.LavadorId;

public class CrearLavador extends Command {
    private final LavadorId lavadorId;
    private final DatosPersonales datosPersonales;

    public CrearLavador(LavadorId lavadorId, DatosPersonales datosPersonales) {
        this.lavadorId = lavadorId;
        this.datosPersonales = datosPersonales;
    }

    public LavadorId getLavadorId() {
        return lavadorId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }
}
