package com.BlogApplication.Blogging.Payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {
    private int id;
    private String categoryTitle;
    private String categoryDescription;

}
