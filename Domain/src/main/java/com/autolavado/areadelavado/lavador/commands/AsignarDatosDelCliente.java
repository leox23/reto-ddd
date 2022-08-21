package com.autolavado.areadelavado.lavador.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.lavador.values.ClienteId;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;

public class AsignarDatosDelCliente extends Command {
    private final LavadorId lavadorId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public AsignarDatosDelCliente(LavadorId lavadorId, ClienteId clienteId, Nombre nombre, Celular celular) {
        this.lavadorId = lavadorId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public LavadorId getLavadorId() { return lavadorId; }

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
