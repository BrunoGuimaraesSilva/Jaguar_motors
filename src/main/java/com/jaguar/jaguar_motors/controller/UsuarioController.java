package com.jaguar.jaguar_motors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import com.jaguar.jaguar_motors.model.Usuario;
import com.jaguar.jaguar_motors.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public List<Usuario> Get() {
        return usuarioRepository.findAll();
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent())
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/usuario", method =  RequestMethod.POST)
    public Usuario Post(@Valid @RequestBody Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Usuario> Put(@PathVariable(value = "id") Long id, @Valid @RequestBody Usuario newUsuario)
    {
        Optional<Usuario> oldUsuario = usuarioRepository.findById(id);
        if(oldUsuario.isPresent()){
            Usuario usuario = oldUsuario.get();
            usuario.setEmail(newUsuario.getEmail());
            usuario.setData_nascimento(newUsuario.getData_nascimento());
            usuario.setNome(newUsuario.getNome());
            usuario.setSobrenome(newUsuario.getSobrenome());
            usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
