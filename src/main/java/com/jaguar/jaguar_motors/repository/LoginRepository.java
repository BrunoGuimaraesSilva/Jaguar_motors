package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.Login;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LoginRepository extends CrudRepository<Login, Integer> {

}