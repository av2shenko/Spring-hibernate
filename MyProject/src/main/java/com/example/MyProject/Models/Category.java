package com.example.MyProject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "structure_level")
    private Long structureLevel;

    public Category(String categoryName, Long structureLevel) {
        this.categoryName = categoryName;
        this.structureLevel = structureLevel;
    }

}