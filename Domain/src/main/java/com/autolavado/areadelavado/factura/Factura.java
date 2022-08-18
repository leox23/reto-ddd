package com.autolavado.areadelavado.factura;

import co.com.sofka.domain.generic.AggregateEvent;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.factura.entities.DatosDeCliente;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.lavador.values.LavadorId;

import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {
    protected FacturaId facturaId;
    protected ClienteId clienteId;
    protected LavadorId lavadorId;
    protected Set<Servicio> servicio;
    protected Set<DatosDeCliente> datosDeCliente;


}
