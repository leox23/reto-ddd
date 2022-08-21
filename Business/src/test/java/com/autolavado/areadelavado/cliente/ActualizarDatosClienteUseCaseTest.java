package com.autolavado.areadelavado.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.cliente.commands.ActualizarDatosCliente;
import com.autolavado.areadelavado.cliente.commands.AgregarDatosPersonales;
import com.autolavado.areadelavado.cliente.events.ClienteCreado;
import com.autolavado.areadelavado.cliente.events.DatosClienteActualizados;
import com.autolavado.areadelavado.cliente.events.DatosPersonalesAgregado;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.DatosPersonalesId;
import com.autolavado.areadelavado.factura.events.AnticipoAgregado;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Tipo;
import com.autolavado.generic.values.Celular;
import com.autolavado.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDatosClienteUseCaseTest {

    @InjectMocks
    private ActualizarDatosClienteUseCase useCase;
    @BeforeEach
    void setup() { useCase = new ActualizarDatosClienteUseCase(); }


    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarDatosCliente() {
        //arrange
        var command = new ActualizarDatosCliente(
                new ClienteId("2"),
                new Nombre("Espartano"),
                new Celular("1111111111"));

        when(repository.getEventsBy("2")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        DatosClienteActualizados datosClienteActualizados = (DatosClienteActualizados) events.get(1);

        Assertions.assertEquals("Espartano", datosClienteActualizados.getNombre().value());

    }

    private List<DomainEvent> history() {
        ClienteId clienteId = new ClienteId("2");
        var event1 = new ClienteCreado(clienteId);

        DatosPersonalesId datosPersonalesId = new DatosPersonalesId("1");
        Nombre nombre = new Nombre("Samuel");
        Celular celular = new Celular("9999999999");
        var event2 = new DatosPersonalesAgregado(datosPersonalesId, nombre, celular);

        return List.of(event1,event2);
    }
}