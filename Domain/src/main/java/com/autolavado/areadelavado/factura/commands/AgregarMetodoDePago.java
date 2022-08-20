package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.areadelavado.factura.values.Tipo;

public class AgregarMetodoDePago extends Command {
    private final ClienteId clienteId;
    private final Tipo tipo;
    private final Anticipo anticipo;

    public AgregarMetodoDePago(ClienteId clienteId, Tipo tipo, Anticipo anticipo) {
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.anticipo = anticipo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
