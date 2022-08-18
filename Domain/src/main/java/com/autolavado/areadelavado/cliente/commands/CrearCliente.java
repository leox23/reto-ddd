package com.autolavado.areadelavado.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.values.ClienteId;

public class CrearCliente extends Command {
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;
    private final Vehiculo vehiculo;

    public CrearCliente(ClienteId clienteId, DatosPersonales datosPersonales, Vehiculo vehiculo) {
        this.clienteId = clienteId;
        this.datosPersonales = datosPersonales;
        this.vehiculo = vehiculo;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
