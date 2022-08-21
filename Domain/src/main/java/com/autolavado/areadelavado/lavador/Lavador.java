package com.autolavado.areadelavado.lavador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.values.ClienteId;
import com.autolavado.areadelavado.lavador.commands.AsignarDatosDelCliente;
import com.autolavado.areadelavado.lavador.entities.Vehiculos;
import com.autolavado.areadelavado.lavador.events.DatosDelClienteAsignados;
import com.autolavado.areadelavado.lavador.events.DatosPersonalesActualizados;
import com.autolavado.areadelavado.lavador.events.LavadorCreado;
import com.autolavado.areadelavado.lavador.events.VehiculoAsignado;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;
import com.autolavado.areadelavado.lavador.values.NombreLavador;
import com.autolavado.areadelavado.lavador.values.VehiculoId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;

import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Lavador extends AggregateEvent<LavadorId> {
    public AsignarDatosDelCliente asignarDatosDelCliente;
    protected Set<DatosPersonales> datosPersonales;
    protected Set<Vehiculos> vehiculos;

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
    public void asignarDatosDelCliente(LavadorId lavadorId, ClienteId clienteId, Nombre nombre, Celular celular){
        appendChange((new DatosDelClienteAsignados(lavadorId, clienteId, nombre, celular)));
    }

    public void actualizarDatosLavador(LavadorId lavadorId, NombreLavador nombreLavador, CelularLavador celularLavador){
        Objects.requireNonNull(lavadorId);
        Objects.requireNonNull(nombreLavador);
        Objects.requireNonNull(celularLavador);
        appendChange(new DatosPersonalesActualizados(lavadorId, nombreLavador, celularLavador));
    }

    public void asignarVehiculo(LavadorId lavadorId, VehiculoId vehiculoId, VehiculosLavados vehiculosLavados, VehiculosRecibidos vehiculosRecibidos){
        Objects.requireNonNull(lavadorId);
        Objects.requireNonNull(vehiculoId);
        appendChange(new VehiculoAsignado(lavadorId, vehiculoId, vehiculosLavados, vehiculosRecibidos));
    }

    //getters
    protected Optional<DatosPersonales> getLavadorPorId(LavadorId lavadorId){
        return datosPersonales
                .stream()
                .filter(cliente -> cliente.identity().equals(lavadorId))
                .findFirst();
    }

    protected Optional<Vehiculos> getVehiculosAsignados(LavadorId lavadorId){
        return vehiculos
                .stream()
                .filter(cliente -> cliente.identity().equals(lavadorId))
                .findFirst();
    }

}
