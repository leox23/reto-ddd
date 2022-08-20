package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.factura.commands.AgregarMetodoDePago;

public class AgregarMetodoDePagoUseCase extends UseCase<RequestCommand<AgregarMetodoDePago>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMetodoDePago> agregarMetodoDePagoRequestCommand) {
        var command = agregarMetodoDePagoRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), repository().getEventsBy(command.getFacturaId().value()));
        factura.agregarMetodoDePago(command.getTipo(), command.getAnticipo());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
