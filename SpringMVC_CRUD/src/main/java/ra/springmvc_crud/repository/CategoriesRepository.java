package ra.springmvc_crud.repository;

import ra.springmvc_crud.model.Categories;

import java.util.List;

public interface CategoriesRepository {
    public List<Categories> findAll();
}
