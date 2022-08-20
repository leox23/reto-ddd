package com.autolavado.areadelavado.factura.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.Tipo;

import java.util.Objects;

public class MetodoDePago extends Entity<ClienteId> {
    private ClienteId clienteId;
    private Tipo metodoDePago;
    private Anticipo anticipo;

    public MetodoDePago(ClienteId clienteId, Tipo metodoDePago, Anticipo anticipo) {
        super(clienteId);
        this.clienteId = clienteId;
        this.metodoDePago = metodoDePago;
        this.anticipo = anticipo;
    }

    public void agregarAnticipo(Anticipo anticipo){
        this.anticipo = Objects.requireNonNull(anticipo);
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Tipo getMetodoDePago() {
        return metodoDePago;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
