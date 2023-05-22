package com.example.motorServicing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.motorServicing.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
	