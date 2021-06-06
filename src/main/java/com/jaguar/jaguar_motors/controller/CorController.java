package com.jaguar.jaguar_motors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import com.jaguar.jaguar_motors.model.Cor;
import com.jaguar.jaguar_motors.repository.CorRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/")
public class CorController {

    @Autowired
    private CorRepository corRepository;

    @RequestMapping(value = "/cor", method = RequestMethod.GET)
    public List<Cor> Get() {
        return corRepository.findAll();
    }

    @RequestMapping(value = "/cor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cor> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Cor> cor = corRepository.findById(id);
        if(cor.isPresent())
            return new ResponseEntity<Cor>(cor.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cor", method =  RequestMethod.POST)
    public Cor Post(@Valid @RequestBody Cor cor)
    {
        return corRepository.save(cor);
    }

    @RequestMapping(value = "/cor/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Cor> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Cor newCor)
    {
        Optional<Cor> oldCor = corRepository.findById(id);
        if(oldCor.isPresent()){
            Cor cor = oldCor.get();
            cor.setCor(newCor.getCor());
            corRepository.save(cor);
            return new ResponseEntity<Cor>(cor, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Cor> cor = corRepository.findById(id);
        if(cor.isPresent()){
            corRepository.delete(cor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
