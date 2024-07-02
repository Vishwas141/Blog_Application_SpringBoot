package com.BlogApplication.Blogging.Repository;

import com.BlogApplication.Blogging.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer>
{

}

