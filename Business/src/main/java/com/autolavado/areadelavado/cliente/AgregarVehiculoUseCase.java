package com.autolavado.areadelavado.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.autolavado.areadelavado.cliente.commands.AgregarVehiculo;

public class AgregarVehiculoUseCase extends UseCase<RequestCommand<AgregarVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarVehiculo> agregarVehiculoRequestCommand) {
        var command = agregarVehiculoRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(),
                repository().getEventsBy(command.getVehiculoId().value())
        );
        cliente.agregarVehiculo(command.getTipoDeVehiculo(), command.getColor());
    }
}
