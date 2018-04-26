package com.swdproject.mmithb.dwp.controller;

import com.swdproject.mmithb.dwp.model.Item;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import com.swdproject.mmithb.dwp.repository.ItemRepository;
import com.swdproject.mmithb.dwp.repository.NestedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    NestedCategoryRepository nestedCategoryRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String welcome() {
        return "DeWarehouse";
    }

    @GetMapping("/inventory")
    public String getItems(Model model) {
        List<Item> item = new ArrayList<>();
        model.addAttribute("item", item);
        List items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "itemPage";
    }

    @GetMapping("/inventory/{name}")
    public String getItems(Model model, @PathVariable("name") String name) {
        List<Item> item = new ArrayList<>();
        model.addAttribute("item", item);
        List items = itemRepository.findAllByCategoryId_NameContains(name);
        model.addAttribute("items", items);
        return "itemPage";
    }

    @GetMapping("/categories")
    public String getCategories(Model model) {
        List<NestedCategory> nestedCategory = new ArrayList<>();
        model.addAttribute("category", nestedCategory);
        List nestedCategories = nestedCategoryRepository.getIndentedCategories();
        model.addAttribute("categories", nestedCategories);
        model.addAttribute("new_category", "");
        return "categoryPage";
    }

    @GetMapping("/categoryTable")
    public String getCategoryTable(Model model) {
        List<NestedCategory> nestedCategory = new ArrayList<>();
        model.addAttribute("category", nestedCategory);
        List<NestedCategory> nestedCategories = nestedCategoryRepository.findAll();
        model.addAttribute("categories", nestedCategories);
        return "categoryTable";
    }

    @PostMapping("/addcat")
    public String addCategory(@RequestParam("category") String oldcategory, Model model){
        Optional<NestedCategory> parentCategory = nestedCategoryRepository.findById(Long.parseLong(oldcategory));
        model.addAttribute("parentCategory", parentCategory);
        return "newCategoryForm";
    }

//    @RequestMapping(value = "/addcat", method = RequestMethod.POST)
//    public String submitRegistrationForm(@RequestParam Map<String, String> reqPar, Model model) {
//
//        String oldCategory = reqPar.get("category");
//        System.out.println(oldCategory);
//
//        model.addAttribute("parent", oldCategory);
//        NestedCategory newCategory = new NestedCategory();
//        model.addAttribute("newCategory", new NestedCategory());
//        return "newCategoryForm";
//    }

//    @GetMapping("/addcat")
//    public String addCategory(Model model, ) {
//        model.addAttribute()
//
//        return "newCategoryForm";
//    }

//    @RequestMapping(value="/addcat", method = RequestMethod.POST)
//    public String addNewCategory (@RequestParam NestedCategory parent, Model model) {
//        model.addAttribute("parent", parent.getName());
//        NestedCategory newCategory = new NestedCategory();
//        newCategory.setParent(parent);
//        model.addAttribute("newcategory", newCategory);
//        return "newCategoryForm";
//    }

}
