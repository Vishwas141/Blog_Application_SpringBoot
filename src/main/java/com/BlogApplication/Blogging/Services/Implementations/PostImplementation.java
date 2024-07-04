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

import java.util.ArrayList;
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


        System.out.println(createdPost);


        return this.posttoPostDto(createdPost);

    }

    @Override
    public PostDto updatePost(PostDto post, int PostId) {

        Post posttobeUpdated=this.postrepo.findById(PostId).orElseThrow(()->new ResourceNotFoundException("Post ","Post id",PostId));

        posttobeUpdated.setTitle(post.getTitle());
        posttobeUpdated.setContent(post.getContent());
        posttobeUpdated.setAddedDate(post.getAddedDate());
        posttobeUpdated.setImageName(post.getImageName());
        Post updatedPost=this.postrepo.save(posttobeUpdated);
        return this.posttoPostDto(updatedPost);
    }

    @Override
    public void deletePost(int PostId)
    {
      Post post=this.postrepo.findById(PostId).orElseThrow(()->new ResourceNotFoundException("Post ","Post id",PostId));
      this.postrepo.delete(post);
      return ;

    }


    @Override
    public List<PostDto> getAllPosts()
    {
        List<Post> posts=this.postrepo.findAll();
        List<PostDto> postDtos=new ArrayList<PostDto>();
        for(Post post:posts)
        {
            postDtos.add(this.posttoPostDto(post));
        }
        return postDtos;
    }

    @Override
    public PostDto getPostById(int PostId) {
        Post post=this.postrepo.findById(PostId).orElseThrow(()->new ResourceNotFoundException("Post ","Post id",PostId));

        return this.posttoPostDto(post);

    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
       Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ","Category id",categoryId));
       List<Post> posts=this.postrepo.findByCategory(cat);

       List<PostDto> postDtos=new ArrayList<>();
       for(Post post:posts)
       {
           postDtos.add(this.posttoPostDto(post));

       }

        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ","User id",userId));

        List<Post> post=this.postrepo.findAllByUser(user);
        List<PostDto> postDtos=new ArrayList<>();

        for(Post post2:post)
        {
            postDtos.add(this.posttoPostDto(post2));

        }
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }

    public Post postDtotoPost(PostDto postDto)
    {
        Post post = new Post();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());

        return post;
    }

    public PostDto posttoPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(post.getCategory().getCategoryId());
        categoryDto.setCategoryTitle(post.getCategory().getCategoryTitle());
        categoryDto.setCategoryDescription(post.getCategory().getCategoryDescription());

        postDto.setCategory(categoryDto);

        UserDto userDto = new UserDto();
        userDto.setId(post.getUser().getId());
        userDto.setName(post.getUser().getName());
        userDto.setEmail(post.getUser().getEmail());
        userDto.setPassword(post.getUser().getPassword());
        userDto.setAbout(post.getUser().getAbout());


        postDto.setUser(userDto);

        postDto.setAddedDate(post.getAddedDate());
        postDto.setImageName(post.getImageName());
        return postDto;
    }


}
