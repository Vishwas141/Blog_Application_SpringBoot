package com.BlogApplication.Blogging.Controllers;


import com.BlogApplication.Blogging.Payloads.PostDto;
import com.BlogApplication.Blogging.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
