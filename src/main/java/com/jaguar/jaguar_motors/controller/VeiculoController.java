package com.jaguar.jaguar_motors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import com.jaguar.jaguar_motors.model.Veiculo;
import com.jaguar.jaguar_motors.repository.VeiculoRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @RequestMapping(value = "/veiculo", method = RequestMethod.GET)
    public List<Veiculo> Get() {
        return veiculoRepository.findAll();
    }

    @RequestMapping(value = "/veiculo/{id}", method = RequestMethod.GET)
    public ResponseEntity<Veiculo> GetById(@PathVariable(value = "id") Long id)
    {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if(veiculo.isPresent())
            return new ResponseEntity<Veiculo>(veiculo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/veiculo", method =  RequestMethod.POST)
    public Veiculo Post(@Valid @RequestBody Veiculo veiculo)
    {
        return veiculoRepository.save(veiculo);
    }

    @RequestMapping(value = "/veiculo/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Veiculo> Put(@PathVariable(value = "id") Long id, @Valid @RequestBody Veiculo newVeiculo)
    {
        Optional<Veiculo> oldVeiculo = veiculoRepository.findById(id);
        if(oldVeiculo.isPresent()){
            Veiculo veiculo = oldVeiculo.get();
            veiculo.setId_marca(newVeiculo.getId_marca());
            veiculo.setId_cor(newVeiculo.getId_cor());
            veiculo.setModelo(newVeiculo.getModelo());
            veiculo.setAno_modelo(newVeiculo.getAno_modelo());
            veiculo.setAno_fabricacao(newVeiculo.getAno_fabricacao());
            veiculo.setValor(newVeiculo.getValor());
            veiculo.setId_usuario(newVeiculo.getId_usuario());
            veiculo.setFoto(newVeiculo.getFoto());
            veiculo.setId_tipo(newVeiculo.getId_tipo());
            veiculoRepository.save(veiculo);
            return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/veiculo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if(veiculo.isPresent()){
            veiculoRepository.delete(veiculo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
