package com.tzonesoft.data.service;

import com.tzonesoft.data.model.Actor;
import com.tzonesoft.data.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;

    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    public Actor getOne(Integer id) {
        return actorRepository.getById(id);
    }

    public Actor save(Actor newActor) {
        return actorRepository.save(newActor);
    }

    public Actor update(Actor replacedActor, Integer id) {
        delete(id);
        return save(replacedActor);
    }

    public void delete(Integer id) {
        Actor actor = getOne(id);
        actorRepository.delete(actor);
    }
}
