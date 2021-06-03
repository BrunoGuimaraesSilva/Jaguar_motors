package com.jaguar.jaguar_motors.repository;

import org.springframework.data.repository.CrudRepository;
import com.jaguar.jaguar_motors.model.UserModel;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserModel, Integer> {

}
