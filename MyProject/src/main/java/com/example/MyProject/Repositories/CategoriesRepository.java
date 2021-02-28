package com.example.MyProject.Repositories;

import com.example.MyProject.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CategoriesRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {

    @Query("SELECT categoryName FROM Category c WHERE c.categoryName  LIKE %:category%")
    String findByCategory(String category);

}