package com.BlogApplication.Blogging.Services.Implementations;

import com.BlogApplication.Blogging.Exceptions.ResourceNotFoundException;
import com.BlogApplication.Blogging.Payloads.UserDto;
import com.BlogApplication.Blogging.Repository.UserRepo;
import com.BlogApplication.Blogging.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.BlogApplication.Blogging.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImplementation implements UserService
{
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto user) {
        User newUser = this.dtoToUser(user);
        User savedUser=this.userRepo.save(newUser);
        return this.userToDto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        // Find the user by userId
        User existingUser = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        // Update the user properties with the new values from UserDto
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAbout(user.getAbout());

        // Save the updated user entity back to the repository
        User updatedUser = this.userRepo.save(existingUser);

        // Convert the updated user entity back to UserDto and return it
        return convertToDto(updatedUser);
    }

    private UserDto convertToDto(User user) {

//        this conversion is also done using modelMapper so it will be reduce lines of code in this functions

        // Create and return a UserDto object from the User entity
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        // Add other properties as needed
        return userDto;
    }



    @Override
    public UserDto getUserById(Integer userId) {
        // Find the user by userId
        User existingUser = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return this.userToDto(existingUser);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(this.userToDto(user));

        }
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {

        // Find the user by userId
        User existingUser = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        this.userRepo.deleteById(userId);

        return ;

    }

    private User dtoToUser(UserDto user )
    {
        User userc=new User();
        userc.setId(user.getId());
        userc.setName(user.getName());
        userc.setEmail(user.getEmail());
        userc.setPassword(user.getPassword());
        userc.setAbout(user.getAbout());
        return userc;
    }

    private UserDto userToDto(User user)
    {
        UserDto userc=new UserDto();
        userc.setId(user.getId());
        userc.setName(user.getName());
        userc.setEmail(user.getEmail());
        userc.setPassword(user.getPassword());
        userc.setAbout(user.getAbout());
        return userc;

    }
}
