package com.BlogApplication.Blogging.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    private int postId;
    private String title;
    private String content;
    private String author;
    private String date;


}
