package com.autolavado.areadelavado.factura;

import co.com.sofka.domain.generic.EventChange;
import com.autolavado.areadelavado.factura.commands.AgregarAnticipo;
import com.autolavado.areadelavado.factura.commands.AgregarDatosCliente;
import com.autolavado.areadelavado.factura.entities.MetodoDePago;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.events.AnticipoAgregado;
import com.autolavado.areadelavado.factura.events.DatosClienteAgregado;
import com.autolavado.areadelavado.factura.events.FacturaCreada;
import com.autolavado.areadelavado.factura.events.MetodoDePagoAgregado;
import com.autolavado.areadelavado.factura.events.TipoDeLavadoAgregado;

import java.util.Set;

public class FacturaChange extends EventChange {
    public FacturaChange(Factura factura) {
        apply((FacturaCreada event) -> {
            factura.precio = event.getPrecio();
            factura.servicio = (Set<Servicio>) event.getServicio();
            factura.metodoDePago = (Set<MetodoDePago>) event.getMetodoDePago();
        });
        apply((AnticipoAgregado event) -> {
            factura.agregarAnticipo = new AgregarAnticipo(event.getFacturaId(), event.getTipo(), event.getAnticipo());
        });
        apply((DatosClienteAgregado event) -> {
            factura.agregarDatosCliente = new AgregarDatosCliente(event.getFacturaId(), event.getClienteId(), event.getNombre(), event.getCelular());
        });
        apply((MetodoDePagoAgregado event) -> {
           factura.agregarMetodoDePago(event.getTipo(), event.getAnticipo());
        });
        apply((TipoDeLavadoAgregado event) -> {
            factura.agregarTipoDeLavado(event.getTipoDeServicioId());
        });
    }
}
