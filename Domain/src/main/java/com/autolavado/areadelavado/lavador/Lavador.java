package com.autolavado.areadelavado.lavador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.VehiculoId;
import com.autolavado.areadelavado.lavador.entities.VehiculosAsignados;
import com.autolavado.areadelavado.lavador.events.DatosDelClienteAsignados;
import com.autolavado.areadelavado.lavador.events.DatosPersonalesActualizados;
import com.autolavado.areadelavado.lavador.events.LavadorCreado;
import com.autolavado.areadelavado.lavador.events.VehiculoAsignado;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;
import com.autolavado.areadelavado.lavador.values.NombreLavador;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;

import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Lavador extends AggregateEvent<LavadorId> {
    protected Set<DatosPersonales> datosPersonales;
    protected Set<VehiculosAsignados> vehiculosAsignados;

    public Lavador(LavadorId lavadorId, NombreLavador nombreLavador, CelularLavador celularLavador) {
        super(lavadorId);
        appendChange(new LavadorCreado(lavadorId, nombreLavador, celularLavador)).apply();
    }

    private Lavador(LavadorId lavadorId) {
        super(lavadorId);
        subscribe(new LavadorChange(this));
    }

    public static Lavador from(LavadorId clienteId, List<DomainEvent> events){
        var lavador = new Lavador(clienteId);
        events.forEach(lavador::applyEvent);
        return lavador;
    }

    // Comportamientos
    public void crearLavador(NombreLavador nombreLavador, CelularLavador celularLavador){
        var lavadorId = new LavadorId();
        Objects.requireNonNull(nombreLavador);
        Objects.requireNonNull(celularLavador);
        appendChange(new LavadorCreado(lavadorId,nombreLavador, celularLavador));
    }

    public void asignarDatosDelCliente(){
        var clienteId = new ClienteId();
        appendChange((new DatosDelClienteAsignados(clienteId)));
    }

    public void actualizarDatosLavador(DatosPersonales datosPersonales){
        var lavadorId = new LavadorId();
        Objects.requireNonNull(datosPersonales);
        appendChange(new DatosPersonalesActualizados(lavadorId, datosPersonales));
    }

    public void asignarVehiculo(VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos){
        var vehiculoId = new VehiculoId();
        Objects.requireNonNull(vehiculosLavados);
        Objects.requireNonNull(vehiculosRecibidos);
        appendChange(new VehiculoAsignado(vehiculoId, vehiculosLavados, vehiculosRecibidos));
    }

    //getters
    protected Optional<DatosPersonales> getLavadorPorId(LavadorId lavadorId){
        return datosPersonales
                .stream()
                .filter(cliente -> cliente.identity().equals(lavadorId))
                .findFirst();
    }

    protected Optional<VehiculosAsignados> getVehiculosAsignados(LavadorId lavadorId){
        return vehiculosAsignados
                .stream()
                .filter(cliente -> cliente.identity().equals(lavadorId))
                .findFirst();
    }

}
