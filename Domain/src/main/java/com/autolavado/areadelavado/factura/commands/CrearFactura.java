package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.entities.DatosDeCliente;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.factura.values.AtencionClienteId;
import com.autolavado.areadelavado.factura.values.FacturaId;

import java.util.Set;

public class CrearFactura extends Command {
    private final FacturaId facturaId;
    //todo preguntar por procedencia de este CLienteID si de aca o de ambas
    private final ClienteId clienteId;
    // usar los de el root CLiente
    private final AtencionClienteId atencionClienteId;
    private final Set<Servicio> servicio;
    private final Set<DatosDeCliente> datosDeClientes;

    public CrearFactura(FacturaId facturaId, ClienteId clienteId, AtencionClienteId atencionClienteId, Set<Servicio> servicio, Set<DatosDeCliente> datosDeClientes) {
        this.facturaId = facturaId;
        this.clienteId = clienteId;
        this.atencionClienteId = atencionClienteId;
        this.servicio = servicio;
        this.datosDeClientes = datosDeClientes;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public AtencionClienteId getAtencionClienteId() {
        return atencionClienteId;
    }

    public Set<Servicio> getServicio() {
        return servicio;
    }

    public Set<DatosDeCliente> getDatosDeClientes() {
        return datosDeClientes;
    }
}
