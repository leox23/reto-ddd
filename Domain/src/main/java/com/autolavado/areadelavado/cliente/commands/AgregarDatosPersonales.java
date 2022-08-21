package com.autolavado.areadelavado.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;

public class AgregarDatosPersonales extends Command {
    private final ClienteId clienteId;
    private final Nombre nombre;

    public AgregarDatosPersonales(ClienteId clienteId, Nombre nombre, Celular celular) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.celular = celular;
    }

    private final Celular celular;

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
