package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.NombreLavador;

public class DatosPersonalesActualizados extends DomainEvent {
    private final LavadorId lavadorId;
    private final DatosPersonales datosPersonales;

    public DatosPersonalesActualizados(LavadorId lavadorId, DatosPersonales datosPersonales){
        super("com.autolavado.areadelavado.DatosPersonalesAgregados");
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
