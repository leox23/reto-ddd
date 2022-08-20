package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.NombreLavador;

public class CrearLavador extends Command {
    private final LavadorId lavadorId;
    private final NombreLavador nombreLavador;
    private final CelularLavador celularLavador;

    public CrearLavador(LavadorId lavadorId, DatosPersonales datosPersonales, NombreLavador nombreLavador, CelularLavador celularLavador) {
        this.lavadorId = lavadorId;
        this.nombreLavador = nombreLavador;
        this.celularLavador = celularLavador;
    }

    public LavadorId getLavadorId() {
        return lavadorId;
    }

    public NombreLavador getNombreLavador() {
        return nombreLavador;
    }

    public CelularLavador getCelularLavador() {
        return celularLavador;
    }
}
