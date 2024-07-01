package ra.springmvc_practice.repository;

import ra.springmvc_practice.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    boolean create(Product product);
}
