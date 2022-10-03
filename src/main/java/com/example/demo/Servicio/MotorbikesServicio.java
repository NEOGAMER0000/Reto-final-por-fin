/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Motorbikes;
import com.example.demo.Repositorio.MotorbikesRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service

public class MotorbikesServicio {
       @Autowired
    private MotorbikesRepositorio motorbikesRepository;

    public List<Motorbikes> getAll(){
        return motorbikesRepository.getAll();
    }

    public Optional<Motorbikes> getMotorbikes(int motorbikesId) {
        return motorbikesRepository.getMotorbikes(motorbikesId);
    }

    /**
     * @param motorbikes
     * @return
     */
    public Motorbikes save(Motorbikes motorbikes){
        if(motorbikes.getId()==null){
            return motorbikesRepository.save(motorbikes);
        }else{
            Optional<Motorbikes>e= motorbikesRepository.getMotorbikes(motorbikes.getId());
            if(e.isEmpty()){
                return motorbikesRepository.save(motorbikes);
            }else{
                return motorbikes;
            }
        }
    }
    
       public Motorbikes update(Motorbikes motorbikes){
        if(motorbikes.getId()!=null){
            Optional<Motorbikes> e= motorbikesRepository.getMotorbikes(motorbikes.getId());
            if(!e.isEmpty()){
                if(motorbikes.getName()!=null){
                    e.get().setName(motorbikes.getName());
                }
                if(motorbikes.getBrand()!=null){
                    e.get().setBrand(motorbikes.getBrand());
                }
                if(motorbikes.getYear()!=null){
                    e.get().setYear(motorbikes.getYear());
                }
                if(motorbikes.getDescription()!=null){
                    e.get().setDescription(motorbikes.getDescription());
                }
                if(motorbikes.getCategory()!=null){
                    e.get().setCategory(motorbikes.getCategory());
                }
                motorbikesRepository.save(e.get());
                return e.get();
            }else{
                return motorbikes;
            }
        }else{
            return motorbikes;
        }
    }

    
    
      public boolean deleteMotorbikes (int id){
        Boolean d = getMotorbikes(id).map(motorbikes -> {
            motorbikesRepository.delete(motorbikes);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}
