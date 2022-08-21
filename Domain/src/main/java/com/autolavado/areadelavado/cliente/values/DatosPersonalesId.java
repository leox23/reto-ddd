package com.autolavado.areadelavado.cliente.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class DatosPersonalesId extends Identity {
    public DatosPersonalesId() {
    }
    public DatosPersonalesId(String id) {
        super(id);
    }
    public static DatosPersonalesId of(String id) {
        return new DatosPersonalesId(id);
    }
}
