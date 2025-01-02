package com.ProductManager.controller;

import com.ProductManager.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductoController {
    private final ProductRepository productRepository;

    public ProductoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Producto> getProductos() {

        return this.productRepository.findAll();
    }

    @PostMapping
    public void registrarProducto(@RequestBody Producto producto) {

        Optional<Producto> resp = productRepository.findProductoByNombre(producto.getNombre());
        if (resp.isPresent()) {
            throw new IllegalStateException("El producto ya existe");
        }
        productRepository.save(producto);
    }

    @PutMapping("/{id}")
    public void actualizarProducto(@PathVariable Long id,@RequestBody Producto producto) {
        Optional<Producto> resp = productRepository.findById(id);
        if (resp.isEmpty()) {
            throw new IllegalStateException("El producto con el ID " + id + " no existe");
        }
        Producto nuevoProducto = resp.get();
        nuevoProducto.setNombre(producto.getNombre());
        nuevoProducto.setPrecio(producto.getPrecio());
        nuevoProducto.setImagen(producto.getImagen());
        nuevoProducto.setFecha(producto.getFecha());

        productRepository.save(nuevoProducto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        Optional<Producto> resp = productRepository.findById(id);
        if (resp.isEmpty()) {
            throw new IllegalStateException("El producto con el ID " + id + " no existe");
        }
        productRepository.deleteById(id);
    }

}
