package com.example.jobPortal.service.implementation;

import com.example.jobPortal.entity.Company;
import com.example.jobPortal.entity.User;
import com.example.jobPortal.payload.company.CompanyDto;
import com.example.jobPortal.payload.user.UserCreateDto;
import com.example.jobPortal.payload.user.UserDto;
import com.example.jobPortal.payload.user.UserUpdateDto;
import com.example.jobPortal.repository.UserRepository;
import com.example.jobPortal.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        User userToCreate = modelMapper.map(userCreateDto, User.class);
        User savedUser = userRepository.save(userToCreate);
        return this.modelMapper.map(savedUser, UserDto.class);

    }



    @Override
    public UserDto getUserById(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(user -> modelMapper.map(user, UserDto.class)).orElse(null);
    }

    @Override
    public List<UserDto> getUsersByName(String name) {
        Optional<List<User>> usersOptional = userRepository.findByName(name);
        return usersOptional.map(users -> users.stream()
                        .map(user -> modelMapper.map(user, UserDto.class))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public List<UserDto> getUsersBySkill(String skill) {
        Optional<List<User>> usersOptional = userRepository.findBySkillsContaining(skill);
        return usersOptional.map(users -> users.stream()
                        .map(user -> modelMapper.map(user, UserDto.class))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public List<UserDto> getUsersByEducation(String education) {
        Optional<List<User>> usersOptional = userRepository.findByEducationContaining(education);
        return usersOptional.map(users -> users.stream()
                        .map(user -> modelMapper.map(user, UserDto.class))
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public UserDto getUserByPhoneNumber(String phoneNumber) {
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        return userOptional.map(user -> modelMapper.map(user, UserDto.class)).orElse(null);
    }

    @Override
    public UserDto updateUser(UserUpdateDto userUpdateDto) {
        Integer userId = userUpdateDto.getId(); // Get the ID from the DTO
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            return null;
        }

        modelMapper.map(userUpdateDto, existingUser);

        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(
                sortDirection.equalsIgnoreCase("asc")
                        ? Sort.Direction.ASC:Sort.Direction.DESC,
                sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<User> userPage = userRepository.findAll(pageable);

        List<UserDto> userDtos = userPage.getContent().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());

        return userDtos;
    }


}
