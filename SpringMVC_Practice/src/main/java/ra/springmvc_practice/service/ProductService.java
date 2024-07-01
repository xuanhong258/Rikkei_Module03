package ra.springmvc_practice.service;

import ra.springmvc_practice.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean create(Product product);
}
