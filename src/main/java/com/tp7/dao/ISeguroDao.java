package com.tp7.dao;

import java.util.ArrayList;

import com.tp7.entidades.Seguro;
import com.tp7.entidades.TipoSeguro;

public interface ISeguroDao {
    public boolean agregarSeguro(Seguro seg);

    public int proximoID();

    public ArrayList<Seguro> obtenerSeguros();

    public ArrayList<Seguro> listarPorTipo(TipoSeguro ts);
}
