package com.Lms.Lms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lms.Lms.Entity.User;

public interface UserRepository extends JpaRepository<User , Long> {

}
