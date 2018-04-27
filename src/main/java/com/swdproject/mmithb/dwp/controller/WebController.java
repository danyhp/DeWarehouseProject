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

    @GetMapping("/inven")
    public String inven() {
        return "inven";
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
        return "inventory";
    }

    @GetMapping("/categoryTable")
    public String getCategoryTable(Model model) {
        List<NestedCategory> nestedCategory = new ArrayList<>();
        model.addAttribute("category", nestedCategory);
        List<NestedCategory> nestedCategories = nestedCategoryRepository.findAll();
        model.addAttribute("categories", nestedCategories);
        return "categoryTable";
    }

//    @PostMapping("/addcat")
//    public String addCategory(@RequestParam("category") String oldcategory, Model model) {
//        NestedCategory parentCategory = nestedCategoryRepository.findOneById(Long.parseLong(oldcategory));
//        model.addAttribute("parentCategory", parentCategory);
//        return "newCategoryForm";
//    }

    @PostMapping("/addnewcat")
    public String saveCategory(@RequestParam("parent") String parent, @RequestParam("newCategory") String newcategory, Model model) {
        nestedCategoryRepository.addNewSubcategory(newcategory, parent);
        return "redirect:/categories";
    }

//    @PostMapping("updatecat")
//    public String updateCategory(@RequestParam("category") String oldcategory, Model model) {
//        NestedCategory existingCategory = nestedCategoryRepository.findOneById(Long.parseLong(oldcategory));
//        model.addAttribute("parentCategory", existingCategory);
//        return "updateCategoryForm";
//    }

    @PostMapping("savecat")
    public String updateSaveCategory(@RequestParam("newcategory") String newcategory, @RequestParam("oldcategory") String oldcategory, Model model) {
        nestedCategoryRepository.updateCategory(newcategory, oldcategory);
        return "redirect:/categories";
    }

    @PostMapping("edit")
    public String editCategory(@RequestParam("category") String oldcategory, @RequestParam(value = "action") String action,
                               Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneById(Long.parseLong(oldcategory));

        if (action.equals("new")) {
            model.addAttribute("parentCategory", parentCategory);
            return "newCategoryForm";
        } else if (action.equals("update")) {
            model.addAttribute("oldCategory", parentCategory);
            return "updateCategoryForm";
        } else if (action.equals("delete")) {
            return "categories";
        }
        return "categories";
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


}
