package com.jaguar.jaguar_motors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import com.jaguar.jaguar_motors.model.LoginAdmin;
import com.jaguar.jaguar_motors.repository.LoginAdminRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/")
public class LoginAdminController {

    @Autowired
    private LoginAdminRepository loginAdminRepository;

    @RequestMapping(value = "/login_admin", method = RequestMethod.GET)
    public List<LoginAdmin> Get() {
        return loginAdminRepository.findAll();
    }

    @RequestMapping(value = "/login_admin/{id}", method = RequestMethod.GET)
    public ResponseEntity<LoginAdmin> GetById(@PathVariable(value = "id") long id)
    {
        Optional<LoginAdmin> loginAdmin = loginAdminRepository.findById(id);
        if(loginAdmin.isPresent())
            return new ResponseEntity<LoginAdmin>(loginAdmin.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login_admin", method =  RequestMethod.POST)
    public LoginAdmin Post(@Valid @RequestBody LoginAdmin loginAdmin)
    {
        return loginAdminRepository.save(loginAdmin);
    }

    @RequestMapping(value = "/login_admin/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<LoginAdmin> Put(@PathVariable(value = "id") long id, @Valid @RequestBody LoginAdmin newLogin)
    {
        Optional<LoginAdmin> oldLogin = loginAdminRepository.findById(id);
        if(oldLogin.isPresent()){
            LoginAdmin loginAdmin = oldLogin.get();
            loginAdmin.setLogin(newLogin.getLogin());
            loginAdmin.setSenha(newLogin.getSenha());
            loginAdmin.setId_usuario(newLogin.getId_usuario());
            loginAdminRepository.save(loginAdmin);
            return new ResponseEntity<LoginAdmin>(loginAdmin, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login_admin/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<LoginAdmin> loginAdmin = loginAdminRepository.findById(id);
        if(loginAdmin.isPresent()){
            loginAdminRepository.delete(loginAdmin.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
