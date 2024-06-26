package ra.springmvc_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_crud.model.Categories;
import ra.springmvc_crud.service.CategoriesService;
import ra.springmvc_crud.serviceImp.CategoriesServiceImp;

import java.util.List;

@Controller
@RequestMapping("/CategoriesController")
public class CategoriesController {
    private final CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesServiceImp categoriesServiceImp) {
        this.categoriesService = categoriesServiceImp;
    }
//    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @GetMapping("findAll")
    public ModelAndView findAllCategories(){
        ModelAndView mav = new ModelAndView("categories");
        List<Categories> categoriesList = categoriesService.findAll();
        mav.addObject("categoriesList", categoriesList);
        return mav;
    }
}
