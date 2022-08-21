package com.autolavado.areadelavado.lavador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.values.ClienteId;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;

public class DatosDelClienteAsignados extends DomainEvent {
    private final ClienteId clienteId;
    private final LavadorId lavadorId;
    private final Nombre nombre;
    private final Celular celular;

    public DatosDelClienteAsignados(LavadorId lavadorId, ClienteId clienteId, Nombre nombre, Celular celular){
        super("com.autolavado.areadelavado.DatosPersonalesAgregados");
        this.lavadorId = lavadorId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.celular = celular;
    }

    public LavadorId getLavadorId() {
        return lavadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Celular getCelular() {
        return celular;
    }

    public com.autolavado.areadelavado.lavador.values.ClienteId getClienteId() {
        return clienteId;
    }

}
