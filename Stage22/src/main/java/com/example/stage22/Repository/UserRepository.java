package com.example.stage22.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.stage22.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String email);

}
