package com.autolavado.areadelavado.cliente;

import co.com.sofka.domain.generic.EventChange;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.events.ClienteCreado;
import com.autolavado.areadelavado.cliente.events.DatosClienteActualizados;
import com.autolavado.areadelavado.cliente.events.VehiculoAgregado;

import java.util.Set;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {
        apply((ClienteCreado event) ->{
            cliente.clienteId = event.getClienteId();
            cliente.datosPersonales = (Set<DatosPersonales>) event.getDatosPersonales();
            cliente.vehiculo = (Set<Vehiculo>) event.getVehiculo();
        });
        apply((DatosClienteActualizados event) -> {
            var datosPersonales = cliente.getDatosPersonalesPorId(event.getClienteId());
            datosPersonales.get().actualizarDatosCliente(event.getNombre(), event.getCelular());
        });
        apply((VehiculoAgregado event) -> {
            var agregar = cliente.getVehiculoPorId(event.getVehiculoId())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra la devolución"));
            agregar.agregarVehiculo(event.getTipoDeVehiculo(), event.getColor());
        });
    }
}
