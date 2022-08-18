package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.values.TipoDeServicioId;

public class TipoDeLavadoAgregado extends DomainEvent{
    private final TipoDeServicioId tipoDeServicioId;

    public TipoDeLavadoAgregado(TipoDeServicioId tipoDeServicioId) {
        super("com.autolavado.areadelavado.TipoDeLavadoAgregado");
        this.tipoDeServicioId = tipoDeServicioId;
    }

    public TipoDeServicioId getTipoDeServicioId() {
        return tipoDeServicioId;
    }
}
