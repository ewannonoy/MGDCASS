package phc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import phc.entity.User;
import phc.services.UserService;

@RestController("/api/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<User>> createUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<User>> updateUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<List<User>> deleteUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
}
