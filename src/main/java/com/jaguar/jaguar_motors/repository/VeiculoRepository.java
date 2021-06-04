package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.Veiculo;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

}
