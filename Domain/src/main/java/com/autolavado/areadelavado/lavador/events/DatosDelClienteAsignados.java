package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
//todo ojo procedencia
import com.autolavado.areadelavado.cliente.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.Nombre;

public class DatosDelClienteAsignados extends DomainEvent {
    //todo verificar si esta procedencia debe tener relacion con agregado root Cliente
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosDelClienteAsignados(ClienteId clienteId, Nombre nombre, Celular celular){
        super("com.autolavado.areadelavado.DatosPersonalesAgregados");
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
