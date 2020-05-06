package de.tiko.productstockmanager.services;

import de.tiko.productstockmanager.models.Product;

import java.util.Set;

public interface ProductService {

    Set<Product> findAllProducts();

    Product findById(Long id);

    Product save(Product product);

}
