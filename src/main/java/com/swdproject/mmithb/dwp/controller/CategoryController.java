package com.swdproject.mmithb.dwp.controller;


import com.swdproject.mmithb.dwp.exception.ResourceNotFoundException;
import com.swdproject.mmithb.dwp.model.Category;
import com.swdproject.mmithb.dwp.model.NestedCategory;
import com.swdproject.mmithb.dwp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/main")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

//    // Show Indented Category
//    @GetMapping("/showcat")
//    public List<NestedCategory> showCategory() {
//        return categoryRepository.showIndent();
//    }

    // Show Indented Category
    @GetMapping("/category")
    public List<Category> showCategory() {
        return categoryRepository.findAll();
    }

    // Get All Category
//    @GetMapping("/categories")
//    public List<Category> getAllCategory() {
//        return categoryRepository.findAll();
//    }

    // Get contains
    @GetMapping("/categories/{name}")
    public List<Category> getContains(@PathVariable(value = "name") String name) {
        return categoryRepository.findAllByNameContains(name);
    }

    // Create a new Category
    @PostMapping("/categories/create")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

//    // Add a new SubCategory
//    @PostMapping("/categories/addsub")
//    public Category addSubCategory(@Valid @RequestBody Category category) {
//        return categoryRepository.addSub(category);
//    }

    // Get a Single Category
    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
    }

//    // Update Category
//    @PutMapping("/categories/{id}")
//    public Category updateCategory(@PathVariable(value = "id") Long categoryId,
//                                         @Valid @RequestBody NestedCategory categoryDetails) {
//
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
//
//        category.setName(categoryDetails.getName());
//        category.setLft(categoryDetails.getLft());
//        category.setRgt(categoryDetails.getRgt());
//
//        return categoryRepository.save(category);
//    }

//    // Delete a Note
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//        Note note = noteRepository.findById(noteId)
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
//
//        noteRepository.delete(note);
//
//        return ResponseEntity.ok().build();
//    }

}
