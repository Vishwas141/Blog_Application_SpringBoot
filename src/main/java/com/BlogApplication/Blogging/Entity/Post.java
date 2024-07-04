package com.BlogApplication.Blogging.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;


    private String title;
    private String content;
    private String imageName;

    private Date addedDate;

    @ManyToOne

    private Category category;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Post [postId=" + postId + ", title=" + title + ", content=" + content;
    }


}
