package com.autolavado.areadelavado.factura.values;

import co.com.sofka.domain.generic.Identity;

public class TipoDeServicioId extends Identity {

    public TipoDeServicioId() {
    }
    public TipoDeServicioId(String id) {
        super(id);
    }
    public static TipoDeServicioId of(String id) {

        return new TipoDeServicioId(id);
    }
}
