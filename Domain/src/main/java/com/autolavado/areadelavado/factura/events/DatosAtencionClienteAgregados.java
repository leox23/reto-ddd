package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.AtencionClienteId;
import com.autolavado.areadelavado.factura.values.MetodoDePago;

public class DatosAtencionClienteAgregados extends DomainEvent {
    private final AtencionClienteId atencionClienteId;
    private final MetodoDePago metodoDePago;
    private final Anticipo anticipo;

    public DatosAtencionClienteAgregados(AtencionClienteId atencionClienteId, MetodoDePago metodoDePago, Anticipo anticipo) {
        super("com.autolavado.areadelavado.DatosAtencionClienteAgregados");
        this.atencionClienteId = atencionClienteId;
        this.metodoDePago = metodoDePago;
        this.anticipo = anticipo;
    }

    public AtencionClienteId getAtencionClienteId() {
        return atencionClienteId;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
