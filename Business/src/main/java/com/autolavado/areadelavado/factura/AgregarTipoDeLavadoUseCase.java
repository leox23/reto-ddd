package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.factura.commands.AgregarTipoDeLavado;

public class AgregarTipoDeLavadoUseCase extends UseCase<RequestCommand<AgregarTipoDeLavado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarTipoDeLavado> agregarTipoDeLavadoRequestCommand) {
        var command = agregarTipoDeLavadoRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), repository().getEventsBy(command.getFacturaId().value()));
        factura.agregarTipoDeLavado(command.getTipoDeServicioId());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));

    }
}
