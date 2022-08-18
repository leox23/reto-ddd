package com.autolavado.areadelavado.lavador;

import co.com.sofka.domain.generic.AggregateEvent;
import com.autolavado.areadelavado.lavador.entities.VehiculosAsignados;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.entities.DatosPersonales;

import java.util.Set;

public class lavador extends AggregateEvent<LavadorId> {
    protected Set<DatosPersonales> datosPersonales;
    protected Set<VehiculosAsignados> vehiculosAsignados;

    public lavador(LavadorId entityId) {
        super(entityId);
    }

    //todo pendiente asuntos de comportamientos
}
