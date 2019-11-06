package ginp14.project3.dao;

import ginp14.project3.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAll();
    Category findById(int id);
}
