package com.name.name.repository;

import org.springframework.data.repository.CrudRepository;

import com.name.name.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
