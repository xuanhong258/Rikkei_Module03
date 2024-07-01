package ra.springmvc_practice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_practice.model.Categories;
import ra.springmvc_practice.model.Product;
import ra.springmvc_practice.service.CategoriesService;
import ra.springmvc_practice.service.ProductService;
import ra.springmvc_practice.serviceImp.CategoriesServiceImp;
import ra.springmvc_practice.serviceImp.ProductServiceImp;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ProductController")
public class ProductController {
    private final ProductService productService;
    private final CategoriesService categoriesService;
    @Autowired
    public ProductController(ProductServiceImp productServiceImp, CategoriesServiceImp categoriesServiceImp) {
        this.productService = productServiceImp;
        this.categoriesService = categoriesServiceImp;
    }

    @GetMapping("/findAll")
    ModelAndView findAllProduct(){
        ModelAndView mav = new ModelAndView("product");
        List<Product> productList = productService.findAll();
        mav.addObject("productList", productList);
        return mav;
    }

    @GetMapping("/initCreateProduct")
    public ModelAndView initCreateCatalog(){
        ModelAndView mav = new ModelAndView("newProduct");
        Product productNew = new Product();
        List<Categories> categoriesList = categoriesService.findAll();
        mav.addObject("productNew", productNew);
        mav.addObject("categoriesList", categoriesList);
        return mav;
    }

    @PostMapping("/createProduct")
    public String createProduct(@Valid Product productNew, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
            }
            model.addAttribute("productNew", productNew);
            List<Categories> categoriesList = categoriesService.findAll();
            model.addAttribute("categoriesList", categoriesList);
            return "newProduct";
        }

        boolean result = productService.create(productNew);

        if(result){
            return "redirect:findAll";
        }
        return "error";
    }
}
