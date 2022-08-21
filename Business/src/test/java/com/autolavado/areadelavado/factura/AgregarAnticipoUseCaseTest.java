package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.commands.AgregarAnticipo;
import com.autolavado.areadelavado.factura.events.AnticipoAgregado;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.Tipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AgregarAnticipoUseCaseTest {
    private AgregarAnticipoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        useCase = new AgregarAnticipoUseCase();
        repository = mock(DomainEventRepository.class);
        useCase.addRepository(repository);
    }

    @Test
    public void AgregarAnticipoUseCaseTestPass() {
        //arrange
        FacturaId facturaId = new FacturaId("1");

        Tipo tipo = new Tipo("efectivo");
        Anticipo anticipo = new Anticipo(200);
        var command = new AgregarAnticipo(facturaId, tipo, anticipo);

        when(repository.getEventsBy("1")).thenReturn(events());


        //act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        AnticipoAgregado anticipoAgregado = (AnticipoAgregado) events.get(0);


        Assertions.assertEquals("1", anticipoAgregado.getFacturaId().value());
        Assertions.assertEquals("efectivo", anticipoAgregado.getTipo().value());
        Assertions.assertEquals(200, anticipoAgregado.getAnticipo().value());
    }

    private List<DomainEvent> events() {
        return List.of(new AnticipoAgregado(
                new FacturaId("1"),
                new Tipo(""),
                new Anticipo(0)
        ));
    }


}