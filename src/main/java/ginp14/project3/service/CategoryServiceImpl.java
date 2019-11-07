package ginp14.project3.service;

import ginp14.project3.dao.CategoryRepository;
import ginp14.project3.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAllByStatus(boolean status) {
        return categoryRepository.findAllByStatus(true);
    }

    @Override
    public Page<Category> findAllByStatus(boolean status, Pageable pageable) {
        return categoryRepository.findAllByStatus(true,pageable);
    }
}
