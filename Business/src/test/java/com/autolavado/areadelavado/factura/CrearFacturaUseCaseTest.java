package com.autolavado.areadelavado.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.autolavado.areadelavado.factura.commands.CrearFactura;
import com.autolavado.areadelavado.factura.entities.MetodoDePago;
import com.autolavado.areadelavado.factura.entities.Servicio;
import com.autolavado.areadelavado.factura.events.FacturaCreada;
import com.autolavado.areadelavado.factura.values.Anticipo;
import com.autolavado.areadelavado.factura.values.ClienteId;
import com.autolavado.areadelavado.factura.values.DiaDeEntrega;
import com.autolavado.areadelavado.factura.values.FacturaId;
import com.autolavado.areadelavado.factura.values.HoraDeEntrega;
import com.autolavado.areadelavado.factura.values.Precio;
import com.autolavado.areadelavado.factura.values.Tipo;
import com.autolavado.areadelavado.factura.values.TipoDeServicioId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CrearFacturaUseCaseTest {
    private  CrearFacturaUseCase useCase;

    @BeforeEach
    public void setup() { (useCase) = new CrearFacturaUseCase();}

    @Test
    public void crearFacturaTestPass() {
        //arrange
        FacturaId facturaId = new FacturaId("fakeFacturaID");
        Precio precio = new Precio("5000");

        TipoDeServicioId tipoDeServicioId = new TipoDeServicioId("fakeTipoDeServicioID");
        DiaDeEntrega diaDeEntrega = new DiaDeEntrega("manana");
        HoraDeEntrega horaDeEntrega = new HoraDeEntrega("12:00");
        Servicio servicio = new Servicio(tipoDeServicioId,diaDeEntrega,horaDeEntrega);

        ClienteId clienteId = new ClienteId("fakeClienteID");
        Tipo tipo = new Tipo("efectivo");
        Anticipo anticipo = new Anticipo("1000");
        MetodoDePago metodoDePago = new MetodoDePago(clienteId, tipo, anticipo);

        var command = new CrearFactura(facturaId, precio, servicio, metodoDePago);

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var facturaCreada = (FacturaCreada) events.get(0);

        Assertions.assertEquals("fakeFacturaID", facturaCreada.getFacturaId().value());
        Assertions.assertEquals("5000", facturaCreada.getPrecio().value());
        Assertions.assertEquals(servicio, facturaCreada.getServicio());
        Assertions.assertEquals(metodoDePago, facturaCreada.getMetodoDePago());

    }

}