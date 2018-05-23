package com.swdproject.mmithb.dwp.controller;

import com.swdproject.mmithb.dwp.model.Item;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import com.swdproject.mmithb.dwp.model.NestedCategoryPref;
import com.swdproject.mmithb.dwp.repository.ItemRepository;
import com.swdproject.mmithb.dwp.repository.NestedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    NestedCategoryRepository nestedCategoryRepository;


    @GetMapping("/")
    public String deWarehouseProj(Model model) {

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
        return "inventIndex";
    }

    @PostMapping("/addnewcat")
    public String saveCategory(@RequestParam("parent") String parent, @RequestParam("addcategory") String newcategory, Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(parent);
        nestedCategoryRepository.addNewSubcategory(newcategory, parentCategory.getName());
        return "redirect:/categories";
    }

    @PostMapping("/savecat")
    public String updateSaveCategory(@RequestParam("newcategory") String newcategory, @RequestParam("oldcategory") String oldcategory, Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(oldcategory);
        nestedCategoryRepository.updateCategory(newcategory, parentCategory.getName());
        return "redirect:/categories";
    }

    @PostMapping("/deletecat")
    public String deleteCategory(@RequestParam("categorydel") String categoryname, Model model) {
        NestedCategory parentCategory = nestedCategoryRepository.findOneByName(categoryname);
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
        Item item = new Item();
        item.setCategoryId(parentCategory);
        item.setName(itemName);
        item.setManufacturer(itemManufacturer);
        item.setQty(qty);
        itemRepository.save(item);
        return "redirect:/categories";
    }

    @PostMapping("/updateitem")
    public String updateItem(@RequestParam("updateIdItem") String itemId,
                           @RequestParam("updateItemName") String itemName,
                           @RequestParam("updateItemManufacturer") String itemManufacturer,
                           @RequestParam("updateItemQty") String itemQty){
        int qty = Integer.parseInt(itemQty);
        Long id = Long.parseLong(itemId);

        Item item = itemRepository.findOneById(id);
        item.setName(itemName);
        item.setManufacturer(itemManufacturer);
        item.setQty(qty);

        itemRepository.save(item);

        return "redirect:/categories";
    }

    @PostMapping("/deleteitem")
    public String deleteItem(@RequestParam("deleteIdItem") String deleteIdItem) {
        Item item = itemRepository.findOneById(Long.parseLong(deleteIdItem));
        itemRepository.delete(item);
        return "redirect:/categories";
    }

}
