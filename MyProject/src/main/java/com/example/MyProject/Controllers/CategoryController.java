package com.example.MyProject.Controllers;

import com.example.MyProject.Models.Category;
import com.example.MyProject.Repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @PostMapping
    public String CategoryCreate(@RequestParam String category, Long level) {
        categoriesRepository.save(new Category(category, level));
        return "saved: " + categoriesRepository.findByCategory(category);
    }

    @GetMapping
    public List<Category> CategoryRead() {
        return (List<Category>) categoriesRepository.findAll();     //Iterable<Category> category = myRepository.findAll();
    }

    @PutMapping("/{id}")
    public String CategoryUpdate(@PathVariable(value = "id") Long id, @RequestParam String category, Long level) {
        Category categoryObject = categoriesRepository.findById(id).orElseThrow();
        categoryObject.setCategoryName(category);
        categoryObject.setStructureLevel(level);
        categoriesRepository.save(categoryObject);
        return "updated: " + categoriesRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String CategoryDelete(@PathVariable(value = "id") Long id) {
        Category categoryObject = categoriesRepository.findById(id).orElseThrow();
        categoriesRepository.delete(categoryObject);
        return "deleted id: " + id;
    }

    @GetMapping("/{id}")
    public Category CategoryGetId(@PathVariable(value = "id") Long id) {
        Category categoryObject = categoriesRepository.findById(id).orElseThrow();
        return categoryObject;
    }

}