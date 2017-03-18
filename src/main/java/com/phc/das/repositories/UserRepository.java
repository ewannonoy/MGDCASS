package com.phc.das.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phc.das.entity.User;
import com.phc.das.entity.User.UserType;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    Optional<User> findSampleQuery(@Param("username") String username);

    List<User> findByUserType(UserType type);

    List<User> findByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCase(String search,
            String search2);
}
