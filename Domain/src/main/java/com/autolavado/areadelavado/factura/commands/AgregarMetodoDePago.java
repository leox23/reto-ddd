package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.TipoDePago;

public class AgregarMetodoDePago extends Command {
    private TipoDePago tipoDePago;

    public AgregarMetodoDePago(TipoDePago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public TipoDePago getTipoDePago() {
        return tipoDePago;
    }
}
