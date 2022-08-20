package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.entities.MetodoDePago;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Precio;


public class FacturaCreada extends DomainEvent {
    private final FacturaId facturaId;
    private final Precio precio;
    private final Servicio servicio;
    private final MetodoDePago metodoDePago;

    public FacturaCreada(FacturaId facturaId, Precio precio, Servicio servicio, MetodoDePago datosDeClientes) {
        super("com.autolavado.areadelavado.FacturaCreada");
        this.facturaId = facturaId;
        this.precio = precio;
        this.servicio = servicio;
        this.metodoDePago = datosDeClientes;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Precio getPrecio() { return precio; }

    public Servicio getServicio() {
        return servicio;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

}
