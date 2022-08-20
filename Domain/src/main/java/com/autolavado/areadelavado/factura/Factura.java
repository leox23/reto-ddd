package com.autolavado.areadelavado.factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.Nombre;
import com.autolavado.areadelavado.factura.entities.MetodoDePago;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.events.AnticipoAgregado;
import com.autolavado.areadelavado.factura.events.DatosClienteAgregado;
import com.autolavado.areadelavado.factura.events.FacturaCreada;
import com.autolavado.areadelavado.factura.events.MetodoDePagoAgregado;
import com.autolavado.areadelavado.factura.events.TipoDeLavadoAgregado;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Precio;
import com.autolavado.areadelavado.factura.values.Tipo;
import com.autolavado.areadelavado.factura.values.TipoDeServicioId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {

    protected Precio precio;
    protected Set<Servicio> servicio;
    protected Set<MetodoDePago> metodoDePago;

    public Factura(FacturaId facturaId, Servicio servicio, MetodoDePago metodoDePago) {
        super(facturaId);
        appendChange(new FacturaCreada(facturaId, precio, servicio, metodoDePago)).apply();
    }

    private Factura(FacturaId facturaId) {
        super(facturaId);
        subscribe(new FacturaChange(this));
    }

    public static Factura from(FacturaId facturaId, List<DomainEvent> events) {
        var factura = new Factura(facturaId);
        events.forEach(factura::applyEvent);
        return factura;
    }

    //comportamientos
    public void crearFactura(Servicio servicio, MetodoDePago metodoDePago) {
        var facturaId = new FacturaId();
        Objects.requireNonNull(servicio);
        Objects.requireNonNull(metodoDePago);
        appendChange(new FacturaCreada(facturaId, precio, servicio, metodoDePago)).apply();
    }

    public void agregarAnticipo(Tipo tipo, Anticipo anticipo) {
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(anticipo);
        appendChange(new AnticipoAgregado(tipo, anticipo)).apply();
    }

    public void agregarDatosCliente(Nombre nombre, Celular celular){
        var clienteId = new ClienteId();
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(celular);
        appendChange(new DatosClienteAgregado(clienteId, nombre, celular)).apply();
    }

    public void agregarMetodoDePago(Tipo tipo, Anticipo anticipo) {
        var clienteId = new com.autolavado.areadelavado.factura.values.ClienteId();
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(anticipo);
        appendChange(new MetodoDePagoAgregado(clienteId, tipo, anticipo)).apply();
    }

    public void agregarTipoDeLavado(TipoDeServicioId tipoDeServicioId){
        Objects.requireNonNull(tipoDeServicioId);
        appendChange(new TipoDeLavadoAgregado(tipoDeServicioId));
    }

    protected Optional<Servicio> getServicioPorId(TipoDeServicioId tipoDeServicioId){
        return servicio
                .stream()
                .filter(servicio -> servicio.identity().equals(tipoDeServicioId))
                .findFirst();
    }

    protected Optional<MetodoDePago> getMetodoDePagoPorId(ClienteId clienteId){
        return metodoDePago
                .stream()
                .filter(metodoDePago -> metodoDePago.identity().equals(clienteId))
                .findFirst();
    }

}
