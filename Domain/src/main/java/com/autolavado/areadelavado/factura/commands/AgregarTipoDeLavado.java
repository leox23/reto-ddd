package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.TipoDeServicioId;

public class AgregarTipoDeLavado extends Command {
    private final TipoDeServicioId tipoDeServicioId;

    public AgregarTipoDeLavado(TipoDeServicioId tipoDeServicioId) {
        this.tipoDeServicioId = tipoDeServicioId;
    }

    public TipoDeServicioId getTipoDeServicioId() {
        return tipoDeServicioId;
    }
}
