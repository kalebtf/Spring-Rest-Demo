package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.model.ActorDTO;
import com.example.demo.model.User;
import com.example.demo.model.Usuario;
import com.example.demo.service.ActorService;
import com.example.demo.service.UserService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    ActorService actorService;

    @Autowired
    Mapper mapper;

    @GetMapping("")
    public List<Actor> list() {
        return actorService.listAllActors();
    }

    @GetMapping("age/{age}")
    public List<Actor> listAgeGreaterThan(@PathVariable Integer age) {
        return actorService.listAllActorsGreaterThan(age);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> get(@PathVariable Integer id) {
        try {
            Actor actor = actorService.getActor(id);
            //Mapper mapper = new DozerBeanMapper();

            ActorDTO actorDTO = mapper.map(actor,ActorDTO.class);
            return new ResponseEntity<ActorDTO>(actorDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ActorDTO>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Actor actor) {
        actorService.saveActor(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Actor actor, @PathVariable Integer id) {
        try {
            actor.setId(id);

            actorService.saveActor(actor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        actorService.deleteActor(id);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}