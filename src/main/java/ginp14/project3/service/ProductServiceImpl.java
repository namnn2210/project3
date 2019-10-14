package ginp14.project3.service;

import ginp14.project3.dao.ProductRepository;
import ginp14.project3.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }


}
