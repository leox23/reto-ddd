package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.AtencionClienteId;
import com.autolavado.areadelavado.factura.values.MetodoDePago;

public class AgregarDatosAtencionCliente extends Command {
    private final AtencionClienteId atencionClienteId;
    private final MetodoDePago metodoDePago;
    private final Anticipo anticipo;

    public AgregarDatosAtencionCliente(AtencionClienteId atencionClienteId, MetodoDePago metodoDePago, Anticipo anticipo) {
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
