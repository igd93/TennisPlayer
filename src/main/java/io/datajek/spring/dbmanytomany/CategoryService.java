package io.datajek.spring.dbmanytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public List<Category> allCategories() {
        return repo.findAll();
    }

    public Category getCategory(int id) {
        Optional<Category> tempCategory = repo.findById(id);
        if(tempCategory.isPresent()) {
            Category category = tempCategory.get();
            return category;
        }
        else {
            throw new CustomNotFoundException("Category with such id" + "does not exist");
        }
    }

    public Category addCategory(Category category) {
        category.setId(0);
        return repo.save(category);
    }

    public void deleteCategory(int id) {
        repo.deleteById(id);
    }

}
