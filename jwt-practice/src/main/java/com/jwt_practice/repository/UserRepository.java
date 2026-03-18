package com.jwt_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt_practice.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, String> {


}
