package com.example.jobPortal.controller;

import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.payload.user.UserCreateDto;
import com.example.jobPortal.payload.user.UserDto;
import com.example.jobPortal.payload.user.UserUpdateDto;
import com.example.jobPortal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int id) {
        UserDto user = userService.getUserById(id);
        if (user != null) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserDto createdUser = userService.createUser(userCreateDto);

        if (createdUser != null) {
            UserDto createdUserDto = modelMapper.map(createdUser, UserDto.class);
            return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserUpdateDto userUpdateDto) {
        UserDto updatedUser = userService.updateUser(userUpdateDto);
        if (updatedUser != null) {
            UserDto updatedUserDto = modelMapper.map(updatedUser, UserDto.class);
            return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUser(
            @RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "sortDirection", required = false, defaultValue = "asc") String sortDirection
    ) {
        List<UserDto> users = userService.getAllUser(pageNumber, pageSize, sortBy, sortDirection);
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
