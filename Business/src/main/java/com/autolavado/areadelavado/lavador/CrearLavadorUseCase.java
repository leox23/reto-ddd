package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.lavador.commands.CrearLavador;

public class CrearLavadorUseCase extends UseCase<RequestCommand<CrearLavador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearLavador> crearLavadorRequestCommand) {
        var command = crearLavadorRequestCommand.getCommand();
        var lavador = new Lavador(command.getLavadorId(), command.getNombreLavador(), command.getCelularLavador());

        emit().onResponse(new ResponseEvents(lavador.getUncommittedChanges()));
    }
}
