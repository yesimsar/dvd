package com.tzonesoft.data.controller;

import com.tzonesoft.data.controller.dto.ActorDTO;
import com.tzonesoft.data.model.Actor;
import com.tzonesoft.data.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping("actor")
    public List<ActorDTO> getAll() {
        List<ActorDTO> actorDTOList = new ArrayList<>();
        List<Actor> actorList = actorService.getAll();

        for (Actor actor : actorList) {
            actorDTOList.add(new ActorDTO(actor));
        }
        return actorDTOList;
    }

    @GetMapping("actor/{id}")
    public ActorDTO getOne(@PathVariable Integer id) {
        return new ActorDTO(actorService.getOne(id));
    }

    @PostMapping("actor")
    @ResponseStatus(HttpStatus.CREATED)
    public ActorDTO save(@RequestBody ActorDTO actorDTO) {
        Actor newActor = new Actor();
        newActor.setFirstName(actorDTO.getFirstName());
        newActor.setLastName(actorDTO.getLastName());
        newActor.setLastUpdate(LocalDateTime.now());
        return new ActorDTO(actorService.save(newActor));
    }

    @PutMapping("actor/{id}")
    public ActorDTO update(@RequestBody ActorDTO actorDTO, @PathVariable Integer id) {
        Actor replacedActor = new Actor();
        replacedActor.setActorId(actorDTO.getActorId());
        replacedActor.setFirstName(actorDTO.getFirstName());
        replacedActor.setLastName(actorDTO.getLastName());
        replacedActor.setLastUpdate(LocalDateTime.now());
        return new ActorDTO(actorService.update(replacedActor, id));
    }

    @DeleteMapping("actor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        actorService.delete(id);

    }


}
