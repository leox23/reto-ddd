package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.generic.values.Nombre;

public class DatosClienteAgregado extends DomainEvent {
    private final FacturaId facturaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosClienteAgregado(FacturaId facturaId, ClienteId clienteId, Nombre nombre, Celular celular) {
        super(String.valueOf(facturaId)); //needed
        this.facturaId = facturaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }
}
