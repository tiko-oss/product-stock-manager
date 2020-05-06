package de.tiko.productstockmanager.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Manufacturer name is required")
    private String manufacturer;

    @NotNull(message = "Model name is required")
    private String model;

    @NotNull(message = "Price is required")
    private Double price;

    private String details;

    private Integer quantity;

    @Builder
    public Product(Long id, String manufacturer, String model, Double price, String details) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.details = details;
        this.quantity = 100;
    }
}


