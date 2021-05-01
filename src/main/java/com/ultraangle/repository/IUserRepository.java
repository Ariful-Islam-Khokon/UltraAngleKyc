package com.ultraangle.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultraangle.entity.User;

public interface IUserRepository extends JpaRepository<User, UUID>{

}
