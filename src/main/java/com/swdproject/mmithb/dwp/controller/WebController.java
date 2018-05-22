package com.swdproject.mmithb.dwp.controller;

import com.swdproject.mmithb.dwp.model.Item;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import com.swdproject.mmithb.dwp.model.NestedCategoryPref;
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

    @GetMapping("/inventory")
    public String getItems(Model model) {
        List<Item> item = new ArrayList<>();
        model.addAttribute("item", item);
        List items = (List) itemRepository.findAll();
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
//        List<NestedCategory> nestedCategory = new ArrayList<>();
//        model.addAttribute("category", nestedCategory);
//        List nestedCategories = nestedCategoryRepository.getIndentedCategories();
//        model.addAttribute("categories", nestedCategories);

        List<NestedCategoryPref> nestedCategory = new ArrayList<>();
        model.addAttribute("category", nestedCategory);
        List nestedCategories = nestedCategoryRepository.getPrefixCategory();
        model.addAttribute("categories", nestedCategories);

        List<NestedCategory> realCategory = (List<NestedCategory>) nestedCategoryRepository.findAll();
        model.addAttribute("realCategory", realCategory);

        List<Item> item = new ArrayList<>();
        model.addAttribute("item", item);
        List items = (List) itemRepository.findAll();
        model.addAttribute("items", items);
//        return "inventoryReady2";
//        return "inventory222ByEka";
        return "inventIndex";
    }


//    @GetMapping("/categoryTable")
//    public String getCategoryTable(Model model) {
//        List<NestedCategory> nestedCategory = new ArrayList<>();
//        model.addAttribute("category", nestedCategory);
//        List<NestedCategory> nestedCategories = nestedCategoryRepository.findAll();
//        model.addAttribute("categories", nestedCategories);
//        return "categoryTable";
//    }

    @PostMapping("/addnewcat")
    public String saveCategory(@RequestParam("parent") String parent, @RequestParam("addcategory") String newcategory, Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(parent);
//        NestedCategory parentCategory = nestedCategoryRepository.findOneById(Long.parseLong(parent));
        nestedCategoryRepository.addNewSubcategory(newcategory, parentCategory.getName());
        return "redirect:/categories";
    }

    @PostMapping("/savecat")
    public String updateSaveCategory(@RequestParam("newcategory") String newcategory, @RequestParam("oldcategory") String oldcategory, Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(oldcategory);
//        NestedCategory parentCategory = nestedCategoryRepository.findOneById(Long.parseLong(oldcategory));
        nestedCategoryRepository.updateCategory(newcategory, parentCategory.getName());
        return "redirect:/categories";
    }

    @PostMapping("/deletecat")
    public String deleteCategory(@RequestParam("categorydel") String categoryname, Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(categoryname);
//        NestedCategory parentCategory = nestedCategoryRepository.findOneById(Long.parseLong(categoryname));
        nestedCategoryRepository.deleteCategory(parentCategory.getName());
        return "redirect:/categories";
    }

    @PostMapping("/addnewitem")
    public String addItem(@RequestParam("parentItemCategory") String parent,
                          @RequestParam("itemName") String itemName,
                          @RequestParam("itemManufacturer") String itemManufacturer,
                          @RequestParam("itemQty") String itemQty,
                          Model model) {
        int qty = Integer.parseInt(itemQty);
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(parent);
//        NestedCategory parentCategory = nestedCategoryRepository.findOneById(Long.parseLong(parent));
        Item item = new Item();
        item.setCategoryId(parentCategory);
        item.setName(itemName);
        item.setManufacturer(itemManufacturer);
        item.setQty(qty);
        itemRepository.save(item);
        return "redirect:/categories";
    }

    @PostMapping("/edit")
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


}
