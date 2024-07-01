package ra.springmvc_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_practice.model.Categories;
import ra.springmvc_practice.service.CategoriesService;
import ra.springmvc_practice.serviceImp.CategoriesServiceImp;

import java.util.List;

@Controller()
@RequestMapping("/CategoriesController")
public class CategoriesController {

    private final CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesServiceImp categoriesServiceImp) {
        this.categoriesService = categoriesServiceImp;
    }

    @GetMapping("/findAll")
    public ModelAndView findAllCategories(){
        ModelAndView mav = new ModelAndView("categories");
        List<Categories> categoriesList = categoriesService.findAll();

        mav.addObject("categoriesList", categoriesList);
        return mav;
    }

    @GetMapping("/initCreate")
    public ModelAndView initCreateCatalog(){
        ModelAndView mav = new ModelAndView("newCategories");
        Categories catalogNew = new Categories();
        mav.addObject("catalogNew", catalogNew);
        return mav;
    }

    @PostMapping("/create")
    public String createCatalog(Categories catalogNew){
        boolean result = categoriesService.create(catalogNew);
        if(result){
            return "redirect:findAll";
        }else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public ModelAndView initUpdate(int catalogId){
        ModelAndView mav = new ModelAndView("updateCategories");

        Categories catalogUpdate = categoriesService.findById(catalogId);
        mav.addObject("catalogUpdate", catalogUpdate);

        return mav;
    }

    @PostMapping("/update")
    public String updateCatalog(Categories catalogUpdate){
        boolean result = categoriesService.update(catalogUpdate);
        if(result){
            return "redirect:findAll";
        }else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteCatalog(int catalogId){
        boolean result = categoriesService.delete(catalogId);
        if(result){
            return "redirect:findAll";
        }else {
            return "error";
        }
    }
}
