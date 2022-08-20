package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.NombreLavador;

public class DatosPersonalesActualizados extends DomainEvent {
    private final LavadorId lavadorId;
    private final NombreLavador nombreLavador;
    private final CelularLavador celularLavador;

    public DatosPersonalesActualizados(LavadorId lavadorId, NombreLavador nombreLavador, CelularLavador celularLavador){
        super("com.autolavado.areadelavado.DatosPersonalesAgregados");
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
