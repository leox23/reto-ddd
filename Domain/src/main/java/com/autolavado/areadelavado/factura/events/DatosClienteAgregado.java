package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.generic.values.Nombre;

public class DatosClienteAgregado extends DomainEvent {

    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosClienteAgregado(ClienteId clienteId, Nombre nombre, Celular celular) {
        super(String.valueOf(clienteId)); //needed
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }
}
