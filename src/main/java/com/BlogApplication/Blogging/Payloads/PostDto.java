package com.BlogApplication.Blogging.Payloads;

import com.BlogApplication.Blogging.Entity.Category;
import com.BlogApplication.Blogging.Entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import com.BlogApplication.Blogging.Payloads.UserDto;
import com.BlogApplication.Blogging.Payloads.CategoryDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter

public class PostDto
{


    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

}
