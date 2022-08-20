package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.lavador.commands.AsignarDatosDelCliente;

public class AsignarDatosDelClienteUseCase extends UseCase<RequestCommand<AsignarDatosDelCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarDatosDelCliente> asignarDatosDelClienteRequestCommand) {
        var command = asignarDatosDelClienteRequestCommand.getCommand();
        var lavador = Lavador.from(command.getLavadorId(),
                repository().getEventsBy(command.getLavadorId().value()));
        var clienteId = new ClienteId(null);
        lavador.asignarDatosDelCliente(clienteId);

        emit().onResponse(new ResponseEvents(lavador.getUncommittedChanges()));
    }
}
