package com.autolavado.areadelavado.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.cliente.commands.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand) {
        var command = crearClienteRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getClienteId().value())
        );
        cliente.crearCliente(command.getDatosPersonales(), command.getVehiculo());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
