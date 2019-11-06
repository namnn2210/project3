package ginp14.project3.service;

import ginp14.project3.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(int id);
}
