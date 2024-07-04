package com.BlogApplication.Blogging.Services.Implementations;

import com.BlogApplication.Blogging.Entity.Category;
import com.BlogApplication.Blogging.Entity.Post;
import com.BlogApplication.Blogging.Entity.User;
import com.BlogApplication.Blogging.Exceptions.ResourceNotFoundException;
import com.BlogApplication.Blogging.Payloads.CategoryDto;
import com.BlogApplication.Blogging.Payloads.PostDto;
import com.BlogApplication.Blogging.Payloads.UserDto;
import com.BlogApplication.Blogging.Repository.CategoryRepo;
import com.BlogApplication.Blogging.Repository.PostRepo;
import com.BlogApplication.Blogging.Repository.UserRepo;
import com.BlogApplication.Blogging.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostImplementation  implements PostService
{
    @Autowired
    private PostRepo postrepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;





    @Override
    public PostDto createPost(PostDto post,Integer userId,Integer categoryId) {

        User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ","User id",userId));

        Category category=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","Category id",categoryId));

        Post p=this.postDtotoPost(post);
        p.setAddedDate(new Date());
        p.setCategory(category);
        p.setUser(user);
        p.setImageName("default.img");


        Post createdPost=this.postrepo.save(p);

        System.out.println("CREATED POST");
        System.out.println(createdPost);


        return this.posttoPostDto(createdPost);

    }

    @Override
    public Post updatePost(PostDto post, int PostId) {
        return null;
    }

    @Override
    public void deletePost(int PostId) {

    }

    @Override
    public List<Post> getAllPosts() {
        return List.of();
    }

    @Override
    public Post getPostById(int PostId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }

    public Post postDtotoPost(PostDto postDto)
    {
        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());

        return post;
    }

    public PostDto posttoPostDto(Post post)
    {

        PostDto postDto = new PostDto();
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());

        CategosrySeriveImpl categories=new CategosrySeriveImpl();
        CategoryDto categoryDto=categories.EntitytoDto(post.getCategory());

        postDto.setCategory(categoryDto);

        UserServiceImplementation userServiceImplementation=new UserServiceImplementation();
        UserDto user=userServiceImplementation.userToDto(post.getUser());

        postDto.setUser(user);


        postDto.setAddedDate(post.getAddedDate());
        post.setUser(post.getUser());
        System.out.println("Hello we are in covertor");
        return postDto;
    }
}
