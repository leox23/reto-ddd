package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.generic.values.Nombre;
import com.autolavado.areadelavado.factura.values.FacturaId;

public class AgregarDatosCliente extends Command {
    private final FacturaId facturaId;
    private final ClienteId clienteId;
    private final Nombre nombre;
    private final Celular celular;

    public AgregarDatosCliente(FacturaId facturaId, ClienteId clienteId, Nombre nombre, Celular celular) {
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
