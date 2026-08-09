package com.anvimol.ecommerce.service;

import java.util.List;

import com.anvimol.ecommerce.model.Orden;

public interface IOrdenService {

    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();
}
