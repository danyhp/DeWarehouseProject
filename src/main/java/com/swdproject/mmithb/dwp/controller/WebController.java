package com.swdproject.mmithb.dwp.controller;

import com.swdproject.mmithb.dwp.model.Greeting;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "showCategory";
    }

    @GetMapping("/category")
    public String categoryPage(Model model){
        return "categoryPage";
    }

    @GetMapping("/addcate")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new NestedCategory());
        return "categoryPage";
    }

    @PostMapping("/addcate")
    public String addCategorySubmit(@ModelAttribute NestedCategory category) {
        return "resultcate";
    }


    // Return JSON of all category
    @GetMapping("/categories")
    public String getAllCategoryData() {
        return "showCategory";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

}
