package de.tiko.productstockmanager.repositories;

import de.tiko.productstockmanager.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
