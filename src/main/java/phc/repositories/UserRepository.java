package phc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import phc.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
}
