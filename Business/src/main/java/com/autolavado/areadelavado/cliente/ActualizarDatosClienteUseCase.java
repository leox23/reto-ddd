package com.autolavado.areadelavado.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.cliente.commands.ActualizarDatosCliente;

public class ActualizarDatosClienteUseCase extends UseCase<RequestCommand<ActualizarDatosCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosCliente> actualizarDatosClienteRequestCommand) {
        var command = actualizarDatosClienteRequestCommand.getCommand();
        var cliente = Cliente.from(
                command.getClienteId(),
                retrieveEvents(command.getClienteId().value())
        );
        cliente.actualizarDatosCliente(command.getNombre(), command.getCelular());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
