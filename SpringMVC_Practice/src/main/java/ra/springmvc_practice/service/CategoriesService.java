package ra.springmvc_practice.service;

import ra.springmvc_practice.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();
    boolean create(Categories catalog);
    Categories findById(int catalogId);
    boolean update(Categories catalog);
    boolean delete(int catalogId);
}
