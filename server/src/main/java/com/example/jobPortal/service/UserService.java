package com.example.jobPortal.service;

import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.payload.user.UserCreateDto;
import com.example.jobPortal.payload.user.UserDto;
import com.example.jobPortal.payload.user.UserUpdateDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserCreateDto user);

    UserDto getUserById(int userId);

    List<UserDto> getUsersByName(String name);

    List<UserDto> getUsersBySkill(String skill);

    List<UserDto> getUsersByEducation(String education);

    UserDto getUserByPhoneNumber(String phoneNumber);

    UserDto updateUser(UserUpdateDto userUpdateDto);

    boolean deleteUser(int userId);

    List<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDirection);
}
