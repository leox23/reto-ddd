package com.autolavado.areadelavado.factura.events;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class DatosClienteAgregado extends DomainEvent {
    //metodo para quitar luego
    public DatosClienteAgregado(String type, String aggregateRootId, String aggregateParentId, UUID uuid) {
        super(type, aggregateRootId, aggregateParentId, uuid);
    }
    //todo, aclara si hay que relacionar aca con AR cliente
}
