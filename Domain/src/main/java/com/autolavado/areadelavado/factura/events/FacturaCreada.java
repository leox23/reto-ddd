package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.factura.entities.DatosDeCliente;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.values.AtencionClienteId;
import com.autolavado.areadelavado.factura.values.FacturaId;


public class FacturaCreada extends DomainEvent {
    private final FacturaId facturaId;
    //todo preguntar por procedencia de este CLienteID si de aca o de ambas
    private final ClienteId clienteId;
    private final AtencionClienteId atencionClienteId;
    private final Servicio servicio;
    private final DatosDeCliente datosDeClientes;

    public FacturaCreada(FacturaId facturaId, ClienteId clienteId, AtencionClienteId atencionClienteId, Servicio servicio, DatosDeCliente datosDeClientes) {
        super("com.autolavado.areadelavado.FacturaCreada");
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

    public Servicio getServicio() {
        return servicio;
    }

    public DatosDeCliente getDatosDeClientes() {
        return datosDeClientes;
    }
}
