package com.users.login.repo;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.users.login.model.Login;

public interface LoginRepository extends JpaRepository<Login,Integer> {
    Login findById(int user_id);
    // Login findByEmailId(String email_id);

    
}
