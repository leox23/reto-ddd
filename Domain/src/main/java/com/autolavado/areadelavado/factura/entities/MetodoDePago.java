package com.autolavado.areadelavado.factura.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.Tipo;

import java.util.Objects;

public class MetodoDePago extends Entity<ClienteId> {
    private ClienteId clienteId;
    private Tipo tipo;
    private Anticipo anticipo;

    public MetodoDePago(ClienteId clienteId, Tipo tipo, Anticipo anticipo) {
        super(clienteId);
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.anticipo = anticipo;
    }

    public void agregarAnticipo(Anticipo anticipo){
        this.anticipo = Objects.requireNonNull(anticipo);
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
