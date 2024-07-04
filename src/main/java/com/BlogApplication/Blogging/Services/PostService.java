package com.BlogApplication.Blogging.Services;

import com.BlogApplication.Blogging.Entity.Post;
import com.BlogApplication.Blogging.Payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PostService
{
   public PostDto createPost(PostDto post,Integer userId,Integer categoryId);

   public Post updatePost(PostDto post,int PostId);

   void deletePost(int PostId);

   List<Post> getAllPosts();

   Post getPostById(int PostId);

   List<Post> getPostsByCategory(Integer categoryId);

   List<Post> getPostByUser(Integer userId);;

   List<Post> searchPosts(String keyword);






}
