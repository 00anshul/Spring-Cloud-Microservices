package com.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user_service.entity.UserInformation;

@Repository
public interface UserRepo extends JpaRepository<UserInformation, Integer> {
    
    // Spring Data JPA generates standard CRUD methods automatically.
    // You can also add custom query methods here:
    
    UserInformation findByEmail(String email);
}