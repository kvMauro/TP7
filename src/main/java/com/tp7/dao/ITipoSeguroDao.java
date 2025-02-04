package com.tp7.dao;

import java.util.List;

import com.tp7.entidades.TipoSeguro;

public interface ITipoSeguroDao {
    public List<TipoSeguro> listar();

    public TipoSeguro buscarTipoSeguro(int id);
}
