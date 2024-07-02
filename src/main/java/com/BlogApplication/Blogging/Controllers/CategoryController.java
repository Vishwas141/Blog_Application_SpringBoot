package com.BlogApplication.Blogging.Controllers;


import com.BlogApplication.Blogging.Payloads.CategoryDto;
import com.BlogApplication.Blogging.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto category)
    {
        CategoryDto categoryDto =this.categoryService.createCategory(category);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{categoryId}")

    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category, @PathVariable int categoryId)
    {
        CategoryDto categoryDto =this.categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")

    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId)
    {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/get/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable int categoryId)
    {
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);

    }

    @GetMapping("/get")
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        List<CategoryDto> categoryDtoList = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);

    }




}
