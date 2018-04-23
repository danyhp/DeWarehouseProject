package com.swdproject.mmithb.dwp.controller;

import com.swdproject.mmithb.dwp.model.NestedCategory;
import com.swdproject.mmithb.dwp.repository.CategoryRepository;
import com.swdproject.mmithb.dwp.repository.NestedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    NestedCategoryRepository nestedCategoryRepository;


    @GetMapping("/inventory")
    public String inventoryPage() {
        return "inventory";
    }


    @GetMapping("/categories")
    public String getTest(Model model) {

        List<NestedCategory> nestedCategory = new ArrayList<>();
        model.addAttribute("category", nestedCategory);
        List<NestedCategory> nestedCategories = nestedCategoryRepository.getIndentedCategories();
        model.addAttribute("categories", nestedCategories);
        return "categoryPage";
    }


}
