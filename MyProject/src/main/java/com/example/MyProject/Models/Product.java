package com.example.MyProject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "article_number", nullable = false)
    private String articleNumber;

    @Column(name = "colour")
    private String colour;

    @Column(name = "size")
    private String size;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    public Product(String productName, String description, String articleNumber, String colour, String size, Double weight, Long categoryId) {
        this.productName = productName;
        this.description = description;
        this.articleNumber = articleNumber;
        this.colour = colour;
        this.size = size;
        this.weight = weight;
        this.categoryId = categoryId;
    }
}
