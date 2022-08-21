package com.autolavado.areadelavado.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.generic.values.Nombre;

public class ActualizarDatosCliente extends Command {
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;


    public ActualizarDatosCliente(ClienteId clienteId, Nombre nombre, Celular celular) {
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
