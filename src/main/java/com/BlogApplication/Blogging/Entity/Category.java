package com.BlogApplication.Blogging.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int categoryId;

    @Column(name = "title")
    private String categoryTitle;
    @Column(name="description")
    private String categoryDescription;


}