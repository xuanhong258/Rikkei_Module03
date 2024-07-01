package ra.springmvc_practice.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springmvc_practice.model.Product;
import ra.springmvc_practice.repository.ProductRepository;
import ra.springmvc_practice.repositoryImp.ProductRepositoryImp;
import ra.springmvc_practice.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepositoryImp productRepositoryImp) {
        this.productRepository = productRepositoryImp;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean create(Product product) {
        return productRepository.create(product);
    }
}
