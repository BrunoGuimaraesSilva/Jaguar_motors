package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
