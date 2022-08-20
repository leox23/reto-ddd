package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.Celular;
import com.autolavado.areadelavado.cliente.values.Nombre;

public class AsignarDatosDelCliente extends Command {
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public AsignarDatosDelCliente(ClienteId lavadorId, Nombre nombre, Celular celular) {
        this.clienteId = lavadorId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public ClienteId getLavadorId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }
}
