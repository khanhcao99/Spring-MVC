package com.example.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demo {
    @GetMapping("/demo")
    public String demo(Model model){
        String name = "khanh";
        model.addAttribute("name", name);
        return "index";
    }
}
