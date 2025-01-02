package com.prueba.controller;

import com.prueba.model.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@RestController
public class ProductoController {

    @GetMapping("/")
    public List<Producto> getNames() {

        return List.of(new Producto(2541,
                "Laptop",
                500, LocalDate.of(2025, Month.JANUARY, 2),
                2));
    }

}
