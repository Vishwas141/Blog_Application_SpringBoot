package com.BlogApplication.Blogging.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

@Data
@NoArgsConstructor
public class UserDto
{
    private int id;

    @NotEmpty
    @Size(min = 4,message = "Username must be graeter than 4 characters")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @NotNull
    private String password;
    @NotNull
    private  String about;
}
