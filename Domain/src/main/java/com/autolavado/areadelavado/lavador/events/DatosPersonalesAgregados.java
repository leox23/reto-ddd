package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.values.Celular;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.Nombre;

public class DatosPersonalesAgregados extends DomainEvent {
    private final LavadorId lavadorId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosPersonalesAgregados(LavadorId lavadorId, Nombre nombre, Celular celular){
        super("com.autolavado.areadelavado.DatosPersonalesAgregados");
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

    public Celular getCelular() {
        return celular;
    }
}
