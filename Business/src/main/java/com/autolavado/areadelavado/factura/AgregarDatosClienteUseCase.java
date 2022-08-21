package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.factura.commands.AgregarDatosCliente;

public class AgregarDatosClienteUseCase extends UseCase<RequestCommand<AgregarDatosCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDatosCliente> agregarDatosClienteRequestCommand) {
        var command = agregarDatosClienteRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaId(), retrieveEvents(command.getFacturaId().value()));
        factura.agregarDatosCliente(command.getFacturaId(), command.getClienteId(), command.getNombre(), command.getCelular());

        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
