package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.MetodoDePago;

public class AnticipoAgregado extends DomainEvent {

    private final MetodoDePago metodoDePago;
    private final Anticipo anticipo;

    public AnticipoAgregado(MetodoDePago metodoDePago, Anticipo anticipo) {
        super("com.autolavado.areadelavado.AnticipoAgregado");
        this.metodoDePago = metodoDePago;
        this.anticipo = anticipo;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
