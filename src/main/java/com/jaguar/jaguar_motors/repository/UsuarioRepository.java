package com.jaguar.jaguar_motors.repository;

import com.jaguar.jaguar_motors.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
