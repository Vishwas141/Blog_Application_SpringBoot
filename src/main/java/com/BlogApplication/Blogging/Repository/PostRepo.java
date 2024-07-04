package com.BlogApplication.Blogging.Repository;

import com.BlogApplication.Blogging.Entity.Category;
import com.BlogApplication.Blogging.Entity.Post;
import com.BlogApplication.Blogging.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface PostRepo extends JpaRepository<Post, Integer>
{
//    List<Post> findAllBy(User user);
//    List<Post> findByCategory(Category category);
}


