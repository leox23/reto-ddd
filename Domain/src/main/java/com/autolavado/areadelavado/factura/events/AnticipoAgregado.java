package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.Tipo;

public class AnticipoAgregado extends DomainEvent {

    private final Tipo tipo;
    private final Anticipo anticipo;

    public AnticipoAgregado(Tipo tipo, Anticipo anticipo) {
        super("com.autolavado.areadelavado.AnticipoAgregado");
        this.tipo = tipo;
        this.anticipo = anticipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
