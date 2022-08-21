package com.autolavado.areadelavado.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.values.ClienteId;

public class ClienteCreado extends DomainEvent {
    private final ClienteId clienteId;

    public ClienteCreado(ClienteId clienteId) {
        super("com.autolavado.areadelavado.ClienteCreado");
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

}
