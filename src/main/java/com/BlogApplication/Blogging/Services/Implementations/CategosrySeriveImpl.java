package com.BlogApplication.Blogging.Services.Implementations;

import com.BlogApplication.Blogging.Entity.Category;
import com.BlogApplication.Blogging.Exceptions.ResourceNotFoundException;
import com.BlogApplication.Blogging.Payloads.CategoryDto;
import com.BlogApplication.Blogging.Repository.CategoryRepo;
import com.BlogApplication.Blogging.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategosrySeriveImpl  implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;;



    @Override
    public CategoryDto createCategory(CategoryDto category) {
        Category newCategory =this.dtotoEntity(category);
        Category createdCategory=this.categoryRepo.save(newCategory);

        return this.EntitytoDto(createdCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto category, int categoryId) {

        Category updatedCategory=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));

        updatedCategory.setCategoryTitle(category.getCategoryTitle());
        updatedCategory.setCategoryDescription(category.getCategoryDescription());
        Category updateCategory=this.categoryRepo.save(updatedCategory);
        return this.EntitytoDto(updateCategory);

    }

    @Override
    public void deleteCategory(int categoryId)
    {
        Category updatedCategory=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        this.categoryRepo.delete(updatedCategory);


    }

    @Override
    public CategoryDto getCategory(int categoryId) {
        Category updatedCategory=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
        return this.EntitytoDto(updatedCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category>categoryList=this.categoryRepo.findAll();

        List<CategoryDto> categoryDtoList=new ArrayList<>();

        for(Category category:categoryList)
            categoryDtoList.add(this.EntitytoDto(category));

        return categoryDtoList;
    }

    public Category dtotoEntity(CategoryDto dto) {
        Category category = new Category();
        category.setCategoryDescription(dto.getCategoryDescription());
        category.setCategoryTitle(dto.getCategoryTitle());
        return category;

    }

    public CategoryDto EntitytoDto(Category dto) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(dto.getCategoryId());
        categoryDto.setCategoryDescription(dto.getCategoryDescription());
        categoryDto.setCategoryTitle(dto.getCategoryTitle());
        return categoryDto;
    }

}
