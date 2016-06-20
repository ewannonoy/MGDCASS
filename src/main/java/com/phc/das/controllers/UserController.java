package com.phc.das.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phc.das.dto.UserDto;
import com.phc.das.entity.User;
import com.phc.das.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(this.convertToDto(userService.getAllUser()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) throws Exception {
        Optional<User> user = userService.getById(id);
        if (!user.isPresent()) {
            throw new Exception();
        }

        return new ResponseEntity<>(this.convertToDto(user.get()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<UserDto>> createUser(@RequestBody UserDto userDto) {
        userService.createUser(this.convertToEntity(userDto));
        return new ResponseEntity<>(this.convertToDto(userService.getAllUser()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<List<UserDto>> updateUser(@RequestBody UserDto userDto) {
        User user = this.convertToEntity(userDto);
        userService.updateUser(user);
        return new ResponseEntity<>(this.convertToDto(userService.getAllUser()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @see https://github.com/jmnarloch/modelmapper-spring-boot-starter
     * @param user
     * @return UserDto
     */
    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        // postDto.setSubmissionDate(post.getSubmissionDate(),
        // userService.getCurrentUser().getPreference().getTimezone());
        return userDto;
    }

    private List<UserDto> convertToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(this.convertToDto(user));
        }
        return userDtos;
    }

    private User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}

