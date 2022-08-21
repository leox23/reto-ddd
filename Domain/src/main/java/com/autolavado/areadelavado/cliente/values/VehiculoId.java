package com.autolavado.areadelavado.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class VehiculoId extends Identity {
    public VehiculoId(ClienteId valor) { super(String.valueOf(valor));}

    public VehiculoId () {};

    public static VehiculoId of(String valor) {
        return new VehiculoId();
    }
}
