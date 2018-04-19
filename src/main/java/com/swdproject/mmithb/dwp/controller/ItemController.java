package com.swdproject.mmithb.dwp.controller;

import com.swdproject.mmithb.dwp.model.Item;
import com.swdproject.mmithb.dwp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main/category")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    // Get All Category
    @GetMapping("/item")
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

}
