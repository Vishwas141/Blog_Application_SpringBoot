package com.BlogApplication.Blogging.Controllers;


import com.BlogApplication.Blogging.Payloads.UserDto;
import com.BlogApplication.Blogging.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{

    @Autowired
   private UserService userService;

   @PostMapping("/create")
   public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto)
   {
       UserDto newUser = userService.createUser(userDto);
       return new ResponseEntity<>(newUser, HttpStatus.CREATED);

   }

   @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId)
   {
       UserDto  updatedUser=this.userService.updateUser(userDto,userId);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
   }

   @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId)
   {
         this.userService.deleteUser(userId);
         return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getAllUsers()
   {
       List<UserDto> users=this.userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);

   }

   @GetMapping("/get/{userId}")

    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
   {
       UserDto user=this.userService.getUserById(userId);
       return new ResponseEntity<>(user,HttpStatus.OK);
   }








}
