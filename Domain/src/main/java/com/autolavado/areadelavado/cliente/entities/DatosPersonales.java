package com.autolavado.areadelavado.cliente.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.generic.values.Nombre;

import java.util.Objects;

public class DatosPersonales extends Entity<ClienteId> {

    private Nombre nombre;
    private Celular celular;

    public DatosPersonales(ClienteId clienteId, Nombre nombre, Celular celular) {
        super(clienteId);
        this.nombre = nombre;
        this.celular = celular;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public void actualizarDatosCliente(Nombre nombre, Celular celular) {
        this.nombre = Objects.requireNonNull(nombre);
        this.celular = Objects.requireNonNull(celular);
    }

}
