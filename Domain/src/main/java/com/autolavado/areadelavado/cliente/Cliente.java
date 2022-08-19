package com.autolavado.areadelavado.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.events.ClienteCreado;
import com.autolavado.areadelavado.cliente.events.DatosClienteActualizados;
import com.autolavado.areadelavado.cliente.events.VehiculoAgregado;
import com.autolavado.areadelavado.cliente.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.Color;
import com.autolavado.areadelavado.cliente.values.Nombre;
import com.autolavado.areadelavado.cliente.values.TipoDeVehiculo;
import com.autolavado.areadelavado.cliente.values.VehiculoId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {

    protected Set<DatosPersonales> datosPersonales;
    protected Set<Vehiculo> vehiculo;

    public Cliente(ClienteId clienteId, DatosPersonales datosPersonales, Vehiculo bono) {
        super(clienteId);
        appendChange(new ClienteCreado(clienteId, datosPersonales, bono)).apply();
    }

    private Cliente(ClienteId clienteId) {
        super(clienteId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> events){
        var cliente= new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    // Comportamientos
    public Optional<Cliente> actualizarDatosCliente(ClienteId clienteId, Nombre nombre, Celular celular){
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(celular);
        appendChange(new DatosClienteActualizados(clienteId, nombre, celular));
    }

    public void agregarVehiculo(VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, Color color){
        Objects.requireNonNull(vehiculoId);
        Objects.requireNonNull(tipoDeVehiculo);
        Objects.requireNonNull(color);
        appendChange(new VehiculoAgregado(vehiculoId, tipoDeVehiculo, color));
    }

    // todo por validad si este comportamiento es el mismo de la linea 36
    public void CrearCliente(ClienteId clienteId, DatosPersonales datosPersonales, Vehiculo vehiculo) {
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(datosPersonales);
        Objects.requireNonNull(vehiculo);
        appendChange(new ClienteCreado(clienteId, datosPersonales, vehiculo));
    }

    //getters
    protected Optional<DatosPersonales> getClientePorId(ClienteId clienteId){
        return datosPersonales
                .stream()
                .filter(cliente -> cliente.identity().equals(clienteId))
                .findFirst();
    }

    protected Optional<Vehiculo> getVehiculoPorId(VehiculoId vehiculoId){
        return vehiculo
                .stream()
                .filter(vehiculo -> vehiculo.identity().equals(vehiculoId))
                .findFirst();
    }

}
