package com.jaguar.jaguar_motors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import com.jaguar.jaguar_motors.model.Login;
import com.jaguar.jaguar_motors.repository.LoginRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public List<Login> Get() {
        return loginRepository.findAll();
    }

    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public ResponseEntity<Login> GetById(@PathVariable(value = "id") int id)
    {
        Optional<Login> login = loginRepository.findById(id);
        if(login.isPresent())
            return new ResponseEntity<Login>(login.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login", method =  RequestMethod.POST)
    public Login Post(@Valid @RequestBody Login login)
    {
        return loginRepository.save(login);
    }

    @RequestMapping(value = "/login/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Login> Put(@PathVariable(value = "id") int id, @Valid @RequestBody Login newLogin)
    {
        Optional<Login> oldLogin = loginRepository.findById(id);
        if(oldLogin.isPresent()){
            Login login = oldLogin.get();
            login.setLogin(newLogin.getLogin());
            login.setSenha(newLogin.getSenha());
            login.setId_usuario(newLogin.getId_usuario());
            loginRepository.save(login);
            return new ResponseEntity<Login>(login, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
        Optional<Login> login = loginRepository.findById(id);
        if(login.isPresent()){
            loginRepository.delete(login.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
