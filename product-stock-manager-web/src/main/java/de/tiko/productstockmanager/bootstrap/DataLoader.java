package de.tiko.productstockmanager.bootstrap;

import de.tiko.productstockmanager.models.Product;
import de.tiko.productstockmanager.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductService productService;

    public DataLoader(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        productService.save(new Product(1l,"Apple",
                "iPhone 20", 1200.00, "256GB"));
        productService.save(new Product(2l, "Apple",
                "iPhone 18SE", 900.00, "Two cameras"));
        productService.save(new Product(3l, "Samsung",
                "Galaxy 30", 600.00, "512GB SD included"));
        productService.save(new Product(4l, "Nokia",
                "Nokia 3310", 100.00, "unbreakable and long lasting battery"));
        productService.save(new Product(5l, "Huawei",
                "P30", 700.00, "5.000.000 Pixel camera"));

    }
}
