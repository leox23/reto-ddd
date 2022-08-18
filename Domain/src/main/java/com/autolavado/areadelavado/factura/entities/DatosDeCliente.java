package com.autolavado.areadelavado.factura.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.MetodoDePago;

public class DatosDeCliente extends Entity<ClienteId> {
    private ClienteId clienteId;
    private MetodoDePago metodoDePago;
    private Anticipo anticipo;


    public DatosDeCliente(ClienteId clienteId, MetodoDePago metodoDePago, Anticipo anticipo) {
        super(clienteId);
        this.clienteId = clienteId;
        this.metodoDePago = metodoDePago;
        this.anticipo = anticipo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
