package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.LoginAdmin;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LoginAdminRepository extends CrudRepository<LoginAdmin, Long> {

}
