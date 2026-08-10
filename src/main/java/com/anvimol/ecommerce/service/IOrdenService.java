package com.anvimol.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.anvimol.ecommerce.model.Orden;
import com.anvimol.ecommerce.model.Usuario;

public interface IOrdenService {

    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario(Usuario usuario);
    Optional<Orden> findById(Integer id);
    Optional<Orden> findByIdWithDetalles(Integer id);
}
