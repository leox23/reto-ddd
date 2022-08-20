package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.Tipo;

public class MetodoDePagoAgregado extends DomainEvent {
    private final ClienteId ClienteId;
    private final Tipo tipo;
    private final Anticipo anticipo;

    public MetodoDePagoAgregado(ClienteId clienteId, Tipo tipo, Anticipo anticipo) {
        super("com.autolavado.areadelavado.DatosAtencionClienteAgregados");
        this.ClienteId = clienteId;
        this.tipo = tipo;
        this.anticipo = anticipo;
    }

    public ClienteId getClienteId() {
        return ClienteId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
