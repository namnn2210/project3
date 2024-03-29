package ginp14.project3.service;

import ginp14.project3.dao.ProductRepository;
import ginp14.project3.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

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

    @Override
    public Page<Product> findAllByCategoryId(int id, Pageable pageable) {
        return productRepository.findAllByCategoryId(id,pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllByTeamId(int id) {
        return productRepository.findAllByTeamId(id);
    }

    @Override
    public Page<Product> findAllByStatus(boolean status, Pageable pageable) {
        return productRepository.findAllByStatus(true,pageable);
    }

    @Override
    public List<Product> findAllByStatus(boolean status) {
        return productRepository.findAllByStatus(true);
    }

    @Override
    public List<Product> findAllByCategoryIdAndStatus(int id, boolean status) {
        return productRepository.findAllByCategoryIdAndStatus(id,status);
    }

    @Override
    public Page<Product> findAllByCategoryIdAndStatus(int id, boolean status, Pageable pageable) {
        return productRepository.findAllByCategoryIdAndStatus(id,status,pageable);
    }
}
