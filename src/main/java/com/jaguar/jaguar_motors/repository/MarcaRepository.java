package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
