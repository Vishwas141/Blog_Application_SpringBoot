package com.BlogApplication.Blogging.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="user_name" ,nullable = false)
    private String name;

    private String email;

    private String password;

    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts=  new ArrayList<>();

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email;
    }

}
