package com.jaguar.jaguar_motors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import com.jaguar.jaguar_motors.model.Marca;
import com.jaguar.jaguar_motors.repository.MarcaRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @RequestMapping(value = "/marca", method = RequestMethod.GET)
    public List<Marca> Get() {
        return marcaRepository.findAll();
    }

    @RequestMapping(value = "/marca/{id}", method = RequestMethod.GET)
    public ResponseEntity<Marca> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Marca> marca = marcaRepository.findById(id);
        if(marca.isPresent())
            return new ResponseEntity<Marca>(marca.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/marca", method =  RequestMethod.POST)
    public Marca Post(@Valid @RequestBody Marca marca)
    {
        return marcaRepository.save(marca);
    }

    @RequestMapping(value = "/marca/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Marca> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Marca newMarca)
    {
        Optional<Marca> oldMarca = marcaRepository.findById(id);
        if(oldMarca.isPresent()){
            Marca marca = oldMarca.get();
            marca.setMarca(newMarca.getMarca());
            marcaRepository.save(marca);
            return new ResponseEntity<Marca>(marca, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/marca/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Marca> marca = marcaRepository.findById(id);
        if(marca.isPresent()){
            marcaRepository.delete(marca.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
