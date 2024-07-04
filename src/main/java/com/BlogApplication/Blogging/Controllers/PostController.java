package com.BlogApplication.Blogging.Controllers;


import com.BlogApplication.Blogging.Payloads.PostDto;
import com.BlogApplication.Blogging.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController
{

    @Autowired
    private PostService postService;


    @PostMapping("/user/{userId}/category/{categoryId}/posts/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto,@PathVariable int userId ,@PathVariable int categoryId    )
    {
        PostDto createdPost=postService.createPost(postdto,userId,categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);

    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> GetPostByUser(@PathVariable int userId)
    {
         List<PostDto>list=postService.getPostByUser(userId);
         return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @DeleteMapping("/posts/{postId}")

    public ResponseEntity<String> deletePost(@PathVariable int postId)
    {
        postService.deletePost(postId);
        return new ResponseEntity<>("Post deleted", HttpStatus.OK);

    }

    @GetMapping("/category/{categoryId}/posts")
    public  ResponseEntity<List<PostDto>> GetPostByU(@PathVariable int categoryId)
    {
        List<PostDto>list= postService.getPostByUser(categoryId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> GetPostById(@PathVariable int postId)
    {
        PostDto postDto=postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);

    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> UpdatePost(@RequestBody PostDto postdto,@PathVariable int postId)
    {
        PostDto updatedPost=postService.updatePost(postdto,postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);

    }





}
