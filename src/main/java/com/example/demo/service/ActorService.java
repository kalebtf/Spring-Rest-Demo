package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.model.User;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    public List<Actor> listAllActors() {
        return actorRepository.findAll();
    }

    public List<Actor> listAllActorsGreaterThan(int age) {
        List<Actor> actors = actorRepository.findAll();

        List<Actor> actorsGreaterThan30 = actors
                .stream()
                .filter(a -> a.getAge() > age)
                .collect(Collectors.toList());

        return actorsGreaterThan30;
    }

    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }

    public Actor getActor(Integer id) {
        return actorRepository.findById(id).get();
    }

    public void deleteActor(Integer id) {
        actorRepository.deleteById(id);
    }
}