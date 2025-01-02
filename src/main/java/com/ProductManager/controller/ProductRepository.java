package com.ProductManager.controller;

import com.ProductManager.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {

    Optional<Producto> findProductoByNombre(String nombre);

}
