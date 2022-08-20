package com.autolavado.areadelavado.factura;

import co.com.sofka.domain.generic.EventChange;
import com.autolavado.areadelavado.factura.events.AnticipoAgregado;
import com.autolavado.areadelavado.factura.events.DatosClienteAgregado;
import com.autolavado.areadelavado.factura.events.FacturaCreada;
import com.autolavado.areadelavado.factura.events.MetodoDePagoAgregado;
import com.autolavado.areadelavado.factura.events.TipoDeLavadoAgregado;

public class FacturaChange extends EventChange {
    public FacturaChange(Factura factura) {
        apply((FacturaCreada event) -> {
            factura.precio = event.getPrecio();
        });
        apply((AnticipoAgregado event) -> {
           factura.agregarAnticipo(event.getTipo(), event.getAnticipo());
        });
        apply((DatosClienteAgregado event) -> {
            factura.agregarDatosCliente(event.getNombre(), event.getCelular());
        });
        apply((MetodoDePagoAgregado event) -> {
           factura.agregarMetodoDePago(event.getTipo(), event.getAnticipo());
        });
        apply((TipoDeLavadoAgregado event) -> {
            factura.agregarTipoDeLavado(event.getTipoDeServicioId());
        });
    }
}
