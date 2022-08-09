package com.example.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class demo {
    @GetMapping("/demo2")
    public String demo1(RedirectAttributes redirectAttributes) {
        String name = "khanh";
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:/demo2";
    }
//    @GetMapping(value = "/demo2")
//    public String demo2(@RequestParam("id") int a){
//        return "index";
//    }
//    @GetMapping(value = "/demo3")
//    public String demo3(@RequestParam int id){
//        int idp = id;
//        return "index";
//    }
//    @GetMapping(value = "/demo4/{id}")
//    public String demo4(@PathVariable int id){
//        return "index";
//    }
}
