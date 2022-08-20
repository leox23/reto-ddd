package com.autolavado.areadelavado.lavador;

import co.com.sofka.domain.generic.EventChange;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;
import com.autolavado.areadelavado.lavador.entities.VehiculosAsignados;
import com.autolavado.areadelavado.lavador.events.DatosDelClienteAsignados;
import com.autolavado.areadelavado.lavador.events.DatosPersonalesActualizados;
import com.autolavado.areadelavado.lavador.events.LavadorCreado;
import com.autolavado.areadelavado.lavador.events.VehiculoAsignado;

public class LavadorChange extends EventChange {
    public LavadorChange(Lavador lavador) {
        apply((LavadorCreado event) ->{
            lavador.datosPersonales.add(new DatosPersonales(event.getLavadorId(), event.getNombreLavador(), event.getCelularLavador()));
        });
        apply((VehiculoAsignado event) ->{
            lavador.vehiculosAsignados.add( new VehiculosAsignados(event.getLavadorId(), event.getVehiculoId(), event.getVehiculosLavados(), event.getVehiculosRecibidos()));
        });
        apply((DatosDelClienteAsignados event) ->{
            //call
            var clienteAsigned = new ClienteId(null);
           lavador.asignarDatosDelCliente(clienteAsigned);
        });
        apply((DatosPersonalesActualizados event) ->{
            var actualizar = lavador.getLavadorPorId(event.getLavadorId())
                    .orElseThrow(() -> new IllegalArgumentException("no se encuentra la devolución"));
            actualizar.actualizarDatosLavador(event.getNombreLavador(), event.getCelularLavador());
        });
    }
}
