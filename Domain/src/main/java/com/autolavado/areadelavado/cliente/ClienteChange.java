package com.autolavado.areadelavado.cliente;

import co.com.sofka.domain.generic.EventChange;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.events.ClienteCreado;

import java.util.Collections;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {
        apply((ClienteCreado event) ->{
            //todo pendiente de corregir inconsistencia
            //cliente.datosPersonales.add(new DatosPersonales(event.getClienteId(), event.Nombre(), event.getPqr()));
        });
    }
}
