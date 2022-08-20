package com.autolavado.areadelavado.factura.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.TipoDeServicioId;

public class AgregarTipoDeLavado extends Command {
    private final FacturaId facturaId;
    private final TipoDeServicioId tipoDeServicioId;

    public AgregarTipoDeLavado(FacturaId facturaId, TipoDeServicioId tipoDeServicioId) {
        this.facturaId = facturaId;
        this.tipoDeServicioId = tipoDeServicioId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public TipoDeServicioId getTipoDeServicioId() {
        return tipoDeServicioId;
    }
}
