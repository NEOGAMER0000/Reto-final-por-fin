/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.MotorbikesInterface;
import com.example.demo.Modelo.Motorbikes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository

public class MotorbikesRepositorio {
    @Autowired
    private MotorbikesInterface motorbikesCrudRepository;
    
      public List<Motorbikes> getAll(){
        return (List<Motorbikes>) motorbikesCrudRepository.findAll();
    }
    
    public Optional<Motorbikes> getMotorbikes(int id){
        return motorbikesCrudRepository.findById(id);
    }

    public Motorbikes save(Motorbikes motorbikes){
        return motorbikesCrudRepository.save(motorbikes);
    }
    
     public void delete(Motorbikes motorbikes){
        motorbikesCrudRepository.delete(motorbikes);
    }
    
     
    
}

