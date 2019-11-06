package ginp14.project3.service;

import ginp14.project3.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    Product findById(int id);
    List<Product> findAllByCategoryId(int id);
    Page<Product> findAllByCategoryId(int id, Pageable pageable);
    void save(Product product);
}
