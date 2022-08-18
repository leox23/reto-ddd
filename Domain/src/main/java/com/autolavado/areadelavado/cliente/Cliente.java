package com.autolavado.areadelavado.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.values.ClienteId;

import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {

    protected Set<DatosPersonales> DatosPersonales;
    protected Set<Vehiculo> Vehiculo;

}
