package com.ultraangle.api.userBase.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultraangle.api.userBase.entity.User;

public interface IUserRepository extends JpaRepository<User, UUID>{

}
