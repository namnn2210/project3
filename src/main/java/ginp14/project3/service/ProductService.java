package ginp14.project3.service;

import ginp14.project3.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int id);
    public List<Product> findAllByCategoryId(int id);
}
