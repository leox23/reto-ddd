package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.entities.MetodoDePago;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Precio;

public class CrearFactura extends Command {
    private final FacturaId facturaId;
    private final Precio precio;
    private final Servicio servicio;
    private final MetodoDePago metodoDePago;

    public CrearFactura(FacturaId facturaId, Precio precio, Servicio servicio, MetodoDePago metodoDePago) {
        this.facturaId = facturaId;
        this.precio = precio;
        this.servicio = servicio;
        this.metodoDePago = metodoDePago;
    }

    public Precio getPrecio() { return precio; }

    public FacturaId getFacturaId() { return facturaId; }

    public Servicio getServicio() {
        return servicio;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }
}
