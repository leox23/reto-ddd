package com.autolavado.areadelavado.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.autolavado.areadelavado.cliente.commands.CrearCliente;
import com.autolavado.areadelavado.cliente.entities.DatosPersonales;
import com.autolavado.areadelavado.cliente.entities.Vehiculo;
import com.autolavado.areadelavado.cliente.events.ClienteCreado;
import com.autolavado.generic.values.Celular;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.Color;
import com.autolavado.generic.values.Nombre;
import com.autolavado.areadelavado.cliente.values.TipoDeVehiculo;
import com.autolavado.areadelavado.cliente.values.VehiculoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearClienteUseCaseTest {
    private CrearClienteUseCase useCase;

    @BeforeEach
    public void setup() { useCase = new CrearClienteUseCase(); }

    @Test
    public void crearClienteTestPass() {
        //arrange
        ClienteId clienteId = ClienteId.of("fakeClienteID");
        Nombre nombre = new Nombre("Julio");
        Celular celular = new Celular("3135555555");
        DatosPersonales datosPersonales = new DatosPersonales(clienteId, nombre, celular);

        var vehiculoId = VehiculoId.of("fakeVehiculoID");
        TipoDeVehiculo tipoDeVehiculo = new TipoDeVehiculo("normal");
        Color color = new Color("negro");
        Vehiculo vehiculo = new Vehiculo(vehiculoId, tipoDeVehiculo, color);

        var command = new CrearCliente(clienteId, datosPersonales, vehiculo);

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var clienteCreado = (ClienteCreado) events.get(0);

        Assertions.assertEquals("fakeClienteID", clienteCreado.aggregateRootId());
        Assertions.assertEquals(datosPersonales, clienteCreado.getDatosPersonales());
        Assertions.assertEquals(vehiculo, clienteCreado.getVehiculo());


    }



}