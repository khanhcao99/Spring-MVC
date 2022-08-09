package com.example.crud_product.Controller;

import com.example.crud_product.Model.Product;
import com.example.crud_product.Service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/display-view")
    public String index(){
        return "display";
    }

    @GetMapping("/create")
    public String createView(){
        return "create";
    }
    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute Product product){
        productService.create(product);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("message", "Tạo thành công");
        modelAndView.addObject("id", product.getId());
        modelAndView.addObject("name", product.getName());
        modelAndView.addObject("amount", product.getAmount());
        return modelAndView;
    }

  @GetMapping(value = "/edit-view")
    public ModelAndView editView(@RequestParam int id){
        int idp = id;
        Product product = productService.findById(idp);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit-view")
    public String  update(@ModelAttribute Product product, Model model ){
        productService.update(product);
        model.addAttribute("message", "Cập nhập thành công");
        model.addAttribute("product", product);
        return "update";
    }

    @GetMapping(value = "/delete-view/{id}")
    public ModelAndView deleteView(@PathVariable int id){
        int idp = id;
        Product product = productService.findById(idp);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping(value = "/delete-view/{id}")
    public String  delete(@ModelAttribute Product product, Model model ){
        productService.delete(product.getId());
        int id = product.getId();
        model.addAttribute("message", "Xóa thành công");
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }


//    @PostMapping("/search")
//    public ModelAndView search(@RequestParam("search") String name){
//        ArrayList<Product> products = productService.fillAllByName(name);
//        ModelAndView modelAndView = new ModelAndView("display");
//        modelAndView.addObject("products", products);
//        modelAndView.addObject("name", name);
//        return modelAndView;
//    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String name, RedirectAttributes redirectAttributes){
        ArrayList<Product> products = productService.fillAllByName(name);
        redirectAttributes.addFlashAttribute("products", products);
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:display-view";
    }
}
