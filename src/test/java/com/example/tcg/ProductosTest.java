package com.example.tcg;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import com.example.tcg.model.Producto;
import com.example.tcg.repository.ProductoRepository;
import com.example.tcg.service.ProductoService; 




public class ProductosTest {
    
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    private Producto producto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        producto = new Producto(null, "Pokemon", "Carta", "Pikachu", 100, "Carta de Pikachu", "urlImagen.jpg");
    }

    @Test
    void testGetProductoByIdFound() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        Producto foundProducto = productoService.getProductoById(1L);
        assertNotNull(foundProducto);
        assertEquals(producto.getNombreProduto(), foundProducto.getNombreProduto());
    }

    @Test
    void testGetProductoByIdNotFound() {
        when(productoRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> productoService.getProductoById(2L));
    }

    @Test
    void testCreateProducto() {
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);
        Producto createdProducto = productoService.saveProducto(producto);
        assertNotNull(createdProducto);
        assertEquals(producto.getNombreProduto(), createdProducto.getNombreProduto());
    }

    @Test
    void testUpdateProducto() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto updatedDetails = new Producto(1L, "Pokemon", "Carta", "Charizard", 150, "Carta de Charizard", "urlImagenCharizard.jpg");
        Producto updatedProducto = productoService.updateProducto(1L, updatedDetails);

        assertNotNull(updatedProducto);
        assertEquals("Charizard", updatedProducto.getNombreProduto());
        assertEquals(150, updatedProducto.getPrecio());
    }

    @Test
    void testUpdateProductoNotFound() {
        when(productoRepository.findById(2L)).thenReturn(Optional.empty());
        Producto updatedDetails = new Producto(2L, "Pokemon", "Carta", "Charizard", 150,
                "Carta de Charizard", "urlImagenCharizard.jpg");
        Producto updatedProducto = productoService.updateProducto(2L, updatedDetails);
        assertNull(updatedProducto);
    }
}
    
