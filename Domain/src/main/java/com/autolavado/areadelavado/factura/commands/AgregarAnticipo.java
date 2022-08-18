package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.MetodoDePago;

public class AgregarAnticipo extends Command {
    private final MetodoDePago metodoDePago;
    private final Anticipo anticipo;

    public AgregarAnticipo(MetodoDePago metodoDePago, Anticipo anticipo) {
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
