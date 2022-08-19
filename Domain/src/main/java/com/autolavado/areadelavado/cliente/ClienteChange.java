package com.autolavado.areadelavado.cliente;

import co.com.sofka.domain.generic.EventChange;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.events.ClienteCreado;
import com.autolavado.areadelavado.cliente.events.DatosClienteActualizados;
import com.autolavado.areadelavado.cliente.events.VehiculoAgregado;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {
        apply((ClienteCreado event) ->{
            cliente.datosPersonales.add(new DatosPersonales(event.getDatosPersonales(), event.getVehiculo()));
        });
        apply((DatosClienteActualizados event) -> {
            var actualizar = cliente.getClientePorId(event.getClienteId())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra la devolución"));
            actualizar.actualizarDatosCliente(event.getNombre(),event.getCelular());
        });
        apply((VehiculoAgregado event) -> {
            var agregar = cliente.getVehiculoPorId(event.getVehiculoId())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra la devolución"));
            agregar.agregarVehiculo(event.getTipoDeVehiculo(), event.getColor());
        });
    }
}
