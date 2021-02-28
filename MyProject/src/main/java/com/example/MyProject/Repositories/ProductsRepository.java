package com.example.MyProject.Repositories;

import com.example.MyProject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT productName FROM Product c WHERE c.productName  LIKE %:product%")
    String findByProduct(String product);

}