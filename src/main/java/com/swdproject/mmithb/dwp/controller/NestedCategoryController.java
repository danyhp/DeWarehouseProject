package com.swdproject.mmithb.dwp.controller;


import com.swdproject.mmithb.dwp.repository.NestedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class NestedCategoryController {

    @Autowired
    NestedCategoryRepository nestedCategoryRepository;



}
