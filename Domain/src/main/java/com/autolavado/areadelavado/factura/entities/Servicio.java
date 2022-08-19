package com.autolavado.areadelavado.factura.entities;

import co.com.sofka.domain.generic.Entity;
import com.autolavado.areadelavado.factura.values.DiaDeEntrega;
import com.autolavado.areadelavado.factura.values.HoraDeEntrega;
import com.autolavado.areadelavado.factura.values.TipoDeServicioId;

public class Servicio extends Entity<TipoDeServicioId> {

    private TipoDeServicioId tipoDeServicioId;
    private DiaDeEntrega diaDeEntrega;
    private HoraDeEntrega horaDeEntrega;

    public Servicio(TipoDeServicioId tipoDeServicioId, DiaDeEntrega diaDeEntrega, HoraDeEntrega horaDeEntrega) {
        super(tipoDeServicioId);
        this.tipoDeServicioId = tipoDeServicioId;
        this.diaDeEntrega = diaDeEntrega;
        this.horaDeEntrega = horaDeEntrega;
    }

    public TipoDeServicioId getTipoDeServicioId() {
        return tipoDeServicioId;
    }

    public DiaDeEntrega getDiaDeEntrega() {
        return diaDeEntrega;
    }

    public HoraDeEntrega getHoraDeEntrega() {
        return horaDeEntrega;
    }
}
