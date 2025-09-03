package com.tut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.model.User;

public interface  UserRepository extends JpaRepository<User, Long> {

}
