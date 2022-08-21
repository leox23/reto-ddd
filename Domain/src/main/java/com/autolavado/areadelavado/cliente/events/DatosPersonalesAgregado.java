package com.autolavado.areadelavado.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.values.DatosPersonalesId;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;

public class DatosPersonalesAgregado extends DomainEvent {
    private final DatosPersonalesId datosPersonalesId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosPersonalesAgregado(DatosPersonalesId datosPersonalesId, Nombre nombre, Celular celular) {
        super("com.autolavado.areadelavado.DatosPersonalesAgregado");
        this.datosPersonalesId = datosPersonalesId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public DatosPersonalesId getDatosPersonalesId() {
        return datosPersonalesId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }
}
