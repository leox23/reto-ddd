package com.autolavado.areadelavado.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.autolavado.areadelavado.cliente.values.ClienteId;
import com.autolavado.areadelavado.cliente.values.Color;
import com.autolavado.areadelavado.cliente.values.TipoDeVehiculo;
import com.autolavado.areadelavado.cliente.values.VehiculoId;

public class AgregarVehiculo extends Command {
    private final ClienteId clienteId;
    private final VehiculoId vehiculoId;
    private final TipoDeVehiculo tipoDeVehiculo;
    private final Color color;

    public AgregarVehiculo(ClienteId clienteId, VehiculoId vehiculoId, TipoDeVehiculo tipoDeVehiculo, Color color) {
        this.clienteId = clienteId;
        this.vehiculoId = vehiculoId;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.color = color;
    }

    public ClienteId getClienteId() { return clienteId; }

    public VehiculoId getVehiculoId() {
        return vehiculoId;
    }

    public TipoDeVehiculo getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public Color getColor() {
        return color;
    }
}
