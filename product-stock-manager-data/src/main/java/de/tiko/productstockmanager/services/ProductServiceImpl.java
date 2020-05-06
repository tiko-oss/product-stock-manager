package de.tiko.productstockmanager.services;

import de.tiko.productstockmanager.models.Product;
import de.tiko.productstockmanager.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<Product> findAllProducts() {

        Set<Product> products = new HashSet<>();

        productRepository.findAll().forEach(products::add);

        return products;
    }

    @Override
    public Product findById(Long id) {
        return productRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

}
