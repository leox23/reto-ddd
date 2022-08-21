package com.autolavado.areadelavado.factura.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Tipo;

import java.util.Objects;

public class MetodoDePago extends Entity<FacturaId> {
    private FacturaId facturaId;
    private Tipo tipo;
    private Anticipo anticipo;

    public MetodoDePago(FacturaId facturaId, Tipo tipo, Anticipo anticipo) {
        super(facturaId);
        this.facturaId = facturaId;
        this.tipo = tipo;
        this.anticipo = anticipo;
    }

    public void agregarAnticipo(FacturaId facturaId, Tipo tipo, Anticipo anticipo){
        this.facturaId = Objects.requireNonNull(facturaId);
        this.tipo = Objects.requireNonNull(tipo);
        this.anticipo = Objects.requireNonNull(anticipo);
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Anticipo getAnticipo() {
        return anticipo;
    }
}
