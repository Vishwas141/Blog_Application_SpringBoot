package com.BlogApplication.Blogging.Services;

import com.BlogApplication.Blogging.Payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user,Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
