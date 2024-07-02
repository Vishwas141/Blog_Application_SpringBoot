package com.BlogApplication.Blogging.Services;

import com.BlogApplication.Blogging.Payloads.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService
{
     //    create

     public CategoryDto createCategory(CategoryDto category);

    public CategoryDto updateCategory(CategoryDto category,int categoryId);

    public void deleteCategory(int categoryId);

    public CategoryDto getCategory(int categoryId);

    public List<CategoryDto> getAllCategories();
}
