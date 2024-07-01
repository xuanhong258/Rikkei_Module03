package ra.springmvc_practice.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springmvc_practice.model.Categories;
import ra.springmvc_practice.repository.CategoriesRepository;
import ra.springmvc_practice.repositoryImp.CategoriesRepositoryImp;
import ra.springmvc_practice.service.CategoriesService;

import java.util.List;
@Service
public class CategoriesServiceImp implements CategoriesService {

    private final CategoriesRepository categoriesRepository;
    @Autowired
    public CategoriesServiceImp(CategoriesRepositoryImp categoriesRepositoryImp) {
        this.categoriesRepository = categoriesRepositoryImp;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public boolean create(Categories catalog) {
        return categoriesRepository.create(catalog);
    }

    @Override
    public Categories findById(int catalogId) {
        return categoriesRepository.findById(catalogId);
    }

    @Override
    public boolean update(Categories catalog) {
        return categoriesRepository.update(catalog);
    }

    @Override
    public boolean delete(int catalogId) {
        return categoriesRepository.delete(catalogId);
    }
}
