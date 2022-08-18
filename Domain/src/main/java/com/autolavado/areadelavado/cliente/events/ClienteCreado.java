package com.autolavado.areadelavado.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.values.ClienteId;

public class ClienteCreado extends DomainEvent {
    private final ClienteId clienteId;
    private final DatosPersonales datosPersonales;
    private final Vehiculo vehiculo;

    // todo no estoy seguro si en realidad este commando debe llevar el ID, el ejemplo es confuso
    public ClienteCreado(ClienteId clienteId, DatosPersonales datosPersonales, Vehiculo vehiculo) {
        super("com.autolavado.areadelavado.ClienteCreado");
        this.clienteId = clienteId;
        this.datosPersonales = datosPersonales;
        this.vehiculo = vehiculo;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

}
