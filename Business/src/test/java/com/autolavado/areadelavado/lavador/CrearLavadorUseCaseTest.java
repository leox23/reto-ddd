package com.autolavado.areadelavado.lavador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.autolavado.areadelavado.lavador.commands.CrearLavador;
import com.autolavado.areadelavado.lavador.events.LavadorCreado;
import com.autolavado.areadelavado.lavador.values.CelularLavador;
import com.autolavado.areadelavado.lavador.values.LavadorId;
import com.autolavado.areadelavado.lavador.values.NombreLavador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearLavadorUseCaseTest {
    private CrearLavadorUseCase useCase;

    @BeforeEach
    public void setup() { useCase = new CrearLavadorUseCase();}

    @Test
    public void CrearLavadorCaseUseTest() {
        ///arrange
        LavadorId lavadorId = new LavadorId("fakeLavadorID");

        NombreLavador nombreLavador = new NombreLavador("Berns");
        CelularLavador celularLavador = new CelularLavador("8888888880");
        var command = new CrearLavador(lavadorId, nombreLavador, celularLavador);

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var lavadorCreado =  (LavadorCreado) events.get(0);

        Assertions.assertEquals("fakeLavadorID", lavadorCreado.getLavadorId().value());
        Assertions.assertEquals("Berns", lavadorCreado.getNombreLavador().value());
        Assertions.assertEquals("8888888880", lavadorCreado.getCelularLavador().value());

    }

}