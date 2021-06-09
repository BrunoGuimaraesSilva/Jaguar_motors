package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findById(Integer id);
}
