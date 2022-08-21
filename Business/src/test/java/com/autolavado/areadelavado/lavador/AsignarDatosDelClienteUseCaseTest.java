package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.lavador.events.DatosDelClienteAsignados;
import com.autolavado.areadelavado.lavador.values.ClienteId;
import com.autolavado.areadelavado.lavador.commands.AsignarDatosDelCliente;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AsignarDatosDelClienteUseCaseTest {
    private AsignarDatosDelClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        useCase = new AsignarDatosDelClienteUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void AsignarDatosDelClienteUseCaseTestPass() {
        //arrange
        LavadorId lavadorId = new LavadorId("1");
        ClienteId clienteId = new ClienteId("20");
        Nombre nombre = new Nombre("Jonas");
        Celular celular = new Celular("9999999999");

        var command = new AsignarDatosDelCliente(lavadorId, clienteId, nombre, celular);

        when(repository.getEventsBy("1")).thenReturn(events());


        //act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        DatosDelClienteAsignados datosDelClienteAsignados = (DatosDelClienteAsignados) events.get(0);

        Assertions.assertEquals("1", datosDelClienteAsignados.getLavadorId().value());
        Assertions.assertEquals("Jonas", datosDelClienteAsignados.getNombre().value());
        Assertions.assertEquals("9999999999", datosDelClienteAsignados.getCelular().value());
    }

    private List<DomainEvent> events() {
        return List.of(new DatosDelClienteAsignados(
                new LavadorId("1"),
                ClienteId.of("30"),
                new Nombre("Jonas"),
                new Celular("9999999999")
        ));
    }


}