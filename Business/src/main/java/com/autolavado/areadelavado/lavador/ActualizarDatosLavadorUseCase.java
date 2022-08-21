package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.lavador.commands.ActualizarDatosLavador;

public class ActualizarDatosLavadorUseCase extends UseCase<RequestCommand<ActualizarDatosLavador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDatosLavador> actualizarDatosLavadorRequestCommand) {
        var command = actualizarDatosLavadorRequestCommand.getCommand();
        var lavador = Lavador.from(command.getLavadorId(),
                repository().getEventsBy(command.getLavadorId().value()));
        lavador.actualizarDatosLavador(command.getLavadorId(), command.getNombreLavador(), command.getCelularLavador());

        emit().onResponse(new ResponseEvents(lavador.getUncommittedChanges()));
    }
}
