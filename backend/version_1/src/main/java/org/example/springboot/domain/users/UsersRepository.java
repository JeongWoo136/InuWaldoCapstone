package org.example.springboot.domain.users;

import org.example.springboot.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public  interface  UsersRepository {
    Users save(Users users);
    Optional<Users> findById(Long Id);
    Optional<Users> findByUserId(String userId);
    Optional<Users> findByName(String name);
    List<Users> findAll();
    //void removeUser(String userId);
}
