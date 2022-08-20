package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Tipo;

public class AgregarAnticipo extends Command {
    private final FacturaId facturaId;
    private final Tipo tipo;
    private final Anticipo anticipo;

    public AgregarAnticipo(FacturaId facturaId, Tipo metodoDePago, Anticipo anticipo) {
        this.facturaId = facturaId;
        this.tipo = metodoDePago;
        this.anticipo = anticipo;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
