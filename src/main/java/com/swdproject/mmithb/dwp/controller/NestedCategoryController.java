package com.swdproject.mmithb.dwp.controller;


import com.swdproject.mmithb.dwp.model.NestedCategory;
import com.swdproject.mmithb.dwp.repository.NestedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/main")
public class NestedCategoryController {

    @Autowired
    NestedCategoryRepository nestedCategoryRepository;

    @PostMapping("/addNewCategory")
    public NestedCategory createCategory(@Valid @RequestBody NestedCategory nestedCategory) {
        return nestedCategoryRepository.save(nestedCategory);
    }


}
