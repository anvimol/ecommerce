package com.anvimol.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anvimol.ecommerce.model.Orden;
import com.anvimol.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;


@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {
    List<Orden> findByUsuario(Usuario usuario);

    @Query("SELECT o FROM Orden o LEFT JOIN FETCH o.detalles WHERE o.id = :id")
    Optional<Orden> findByIdWithDetalles(@Param("id") Integer id);
}
