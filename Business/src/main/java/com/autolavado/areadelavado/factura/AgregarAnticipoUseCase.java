package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.factura.commands.AgregarAnticipo;

public class AgregarAnticipoUseCase extends UseCase<RequestCommand<AgregarAnticipo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAnticipo> agregarAnticipoRequestCommand) {
        var command = agregarAnticipoRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), repository().getEventsBy(command.getFacturaId().value()));
        factura.agregarAnticipo(command.getTipo(), command.getAnticipo());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
