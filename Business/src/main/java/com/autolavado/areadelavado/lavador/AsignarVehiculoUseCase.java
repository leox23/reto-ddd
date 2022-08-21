package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.lavador.commands.AsignarVehiculo;

public class AsignarVehiculoUseCase extends UseCase<RequestCommand<AsignarVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarVehiculo> asignarVehiculoRequestCommand) {
        var command = asignarVehiculoRequestCommand.getCommand();
        var lavador = Lavador.from(command.getLavadorId(),
                repository().getEventsBy(command.getLavadorId().value()));
        lavador.asignarVehiculo(command.getLavadorId(), command.getVehiculoId(), command.getVehiculosLavados(), command.getVehiculosRecibidos());
        emit().onResponse(new ResponseEvents(lavador.getUncommittedChanges()));
    }

}
