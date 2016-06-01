package phc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phc.entity.User;
import phc.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User>getAllUser() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User createUser() {
		User user = new User();
		user.setFirstName("nonoy");
		user.setUsername("ewan");
		return userRepository.save(user);
	}
}
