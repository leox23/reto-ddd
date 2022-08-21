package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.commands.AgregarDatosCliente;
import com.autolavado.areadelavado.factura.events.DatosClienteAgregado;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.areadelavado.factura.values.FacturaId;
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

class AgregarDatosClienteUseCaseTest {
    private AgregarDatosClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        useCase = new AgregarDatosClienteUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void agregarDatosClienteUseCaseTestPass() {
        //arrange
        FacturaId facturaId = new FacturaId("2");
        ClienteId clienteId = new ClienteId("20");
        Nombre nombre = new Nombre("Leonidas");
        Celular celular = new Celular("0000000000");
        var command = new AgregarDatosCliente(facturaId, clienteId, nombre, celular);

        when(repository.getEventsBy("2")).thenReturn(events());


        //act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        DatosClienteAgregado datosClienteAgregado = (DatosClienteAgregado) events.get(0);


        Assertions.assertEquals("2", datosClienteAgregado.aggregateRootId());
        Assertions.assertEquals("Leonidas", datosClienteAgregado.getNombre().value());
        Assertions.assertEquals("0000000000", datosClienteAgregado.getCelular().value());
    }

    private List<DomainEvent> events() {
        return List.of(new DatosClienteAgregado(
                new FacturaId("2"),
                ClienteId.of("20"),
                new Nombre("Leonidas"),
                new Celular("0000000000")
        ));
    }

}