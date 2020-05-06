package de.tiko.productstockmanager.services;

import de.tiko.productstockmanager.models.Product;
import de.tiko.productstockmanager.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl service;

    Product returnProduct;

    @BeforeEach
    void setUp() {
        returnProduct = Product.builder().id(1l).build();
    }

    @Test
    void findAllProducts() {
        Set<Product> returnProductsSet = new HashSet<>();

        returnProductsSet.add(Product.builder().id(1l).build());
        returnProductsSet.add(Product.builder().id(2l).build());

        when(productRepository.findAll()).thenReturn(returnProductsSet);

        Set<Product> products = service.findAllProducts();

        assertNotNull(products);
        assertEquals(returnProductsSet.size(), products.size());
    }

    @Test
    void findById() {

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(returnProduct));

        Product product = service.findById(1L);

        assertNotNull(product);

    }

    @Test
    void findByIdNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        Product product = service.findById(1L);

        assertNull(product);
    }

    @Test
    void save() {

        Product productToSave = Product.builder().id(1L).build();

        when(productRepository.save(any())).thenReturn(returnProduct);

        Product savedProduct = service.save(productToSave);

        assertNotNull(savedProduct);

        verify(productRepository).save(any());
    }
}