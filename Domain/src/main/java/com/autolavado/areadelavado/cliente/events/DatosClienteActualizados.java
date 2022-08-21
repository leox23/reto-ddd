package com.autolavado.areadelavado.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.generic.values.Nombre;

public class DatosClienteActualizados extends DomainEvent {
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosClienteActualizados( ClienteId clienteId, Nombre nombre, Celular celular) {
        super("com.autolavado.areadelavado.DatosClienteActualizados");
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
