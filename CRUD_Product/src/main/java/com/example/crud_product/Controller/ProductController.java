package com.example.crud_product.Controller;

import com.example.crud_product.Model.Product;
import com.example.crud_product.Service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping("/ProductManager")
public class ProductController {
    private final ProductService productService = new ProductService();

    @GetMapping
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("display");
        ArrayList<Product> products = productService.fillAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

//    @GetMapping("/create")
//    public String viewCreate(){
//        return "create";
//    }

    @PostMapping("/creat")
    public ModelAndView createProduct(@ModelAttribute Product product){
        productService.create(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "Tạo thành công");
        modelAndView.addObject("id", product.getId());
        modelAndView.addObject("name", product.getName());
        modelAndView.addObject("amount", product.getAmount());
        return modelAndView;
    }

    @GetMapping("/edit-view")
    public ModelAndView editView(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id")) ;
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
}
