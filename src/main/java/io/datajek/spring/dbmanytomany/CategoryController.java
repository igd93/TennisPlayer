package io.datajek.spring.dbmanytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> allCategories() {
        return categoryService.allCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCaegory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }



}
