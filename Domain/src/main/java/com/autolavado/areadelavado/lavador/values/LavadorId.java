package com.autolavado.areadelavado.lavador.values;

import co.com.sofka.domain.generic.Identity;

public class LavadorId extends Identity {

    public LavadorId() {
    }
    public LavadorId(String id) {
        super(id);
    }
    public static LavadorId of(String id) {

        return new LavadorId(id);
    }
}
