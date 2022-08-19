package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.values.ClienteId;

public class DatosDelClienteAsignados extends DomainEvent {
    private final ClienteId clienteId;

    public DatosDelClienteAsignados(ClienteId clienteId){
        super("com.autolavado.areadelavado.DatosPersonalesAgregados");
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

}
