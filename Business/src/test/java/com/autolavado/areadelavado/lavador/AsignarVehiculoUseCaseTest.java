package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.values.VehiculoId;
import com.autolavado.areadelavado.lavador.commands.AsignarVehiculo;
import com.autolavado.areadelavado.lavador.events.VehiculoAsignado;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.VehiculosLavados;
import com.autolavado.areadelavado.lavador.values.VehiculosRecibidos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsignarVehiculoUseCaseTest {
    private AsignarVehiculoUseCase useCase;


    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        useCase = new AsignarVehiculoUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void asignarVehiculoUseCaseTestPass() {
        //arrange
        List detalleVehiculos = new List();
        detalleVehiculos.add("nissan");detalleVehiculos.add("toyota");
        Boolean todoCompletado = false;
        VehiculosLavados vehiculosLavados = new VehiculosLavados(detalleVehiculos,todoCompletado);
        var command = new AsignarVehiculo(
                LavadorId.of("1"),
                new VehiculoId("52"),
                vehiculosLavados,
                new VehiculosRecibidos(2)
        );
        when(repository.getEventsBy("52")).thenReturn(events());

        //act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("52")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //Assert
        VehiculoAsignado asignarVehiculo = (VehiculoAsignado) events.get(0);

        Assertions.assertEquals("1", asignarVehiculo.getLavadorId().value());
        Assertions.assertEquals(vehiculosLavados, asignarVehiculo.getVehiculosLavados());
        Assertions.assertEquals(2, asignarVehiculo.getVehiculosRecibidos().value());


    }

    private java.util.List<DomainEvent> events(){
        List detalleVehiculos = new List();
        detalleVehiculos.add("nissan");detalleVehiculos.add("toyota");
        Boolean todoCompletado = false;
        VehiculosLavados vehiculosLavados = new VehiculosLavados(detalleVehiculos,todoCompletado);

        return java.util.List.of(new VehiculoAsignado(
                LavadorId.of("1"),
                VehiculoId.of("21"),
                vehiculosLavados,
                new VehiculosRecibidos(2)
        ));
    }
}