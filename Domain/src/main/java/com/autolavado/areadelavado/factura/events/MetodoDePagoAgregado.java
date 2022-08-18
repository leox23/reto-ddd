package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.TipoDePago;

public class MetodoDePagoAgregado extends DomainEvent {
    private final TipoDePago tipoDePago;

    public MetodoDePagoAgregado(TipoDePago tipoDePago) {
        super("com.autolavado.areadelavado.MetodoDePagoAgregado");
        this.tipoDePago = tipoDePago;
    }

    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }
}
