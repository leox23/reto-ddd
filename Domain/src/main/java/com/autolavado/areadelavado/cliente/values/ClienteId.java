package com.autolavado.areadelavado.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(ClienteId valor) { super(valor);}

    public ClienteId () {};

    public static ClienteId of(String valor) {
        return new ClienteId(valor);
    }
}
