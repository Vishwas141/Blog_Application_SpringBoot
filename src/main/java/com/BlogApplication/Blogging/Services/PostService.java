package com.BlogApplication.Blogging.Services;

import com.BlogApplication.Blogging.Entity.Post;
import com.BlogApplication.Blogging.Payloads.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PostService
{
   public PostDto createPost(PostDto post,Integer userId,Integer categoryId);

   public PostDto updatePost(PostDto post,int PostId);

   void deletePost(int PostId);

   List<PostDto> getAllPosts();

   PostDto getPostById(int PostId);

   List<PostDto> getPostsByCategory(Integer categoryId);

   List<PostDto> getPostByUser(Integer userId);;

   List<PostDto> searchPosts(String keyword);






}
