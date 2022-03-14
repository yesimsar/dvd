package com.tzonesoft.data.controller.dto;

import com.tzonesoft.data.model.Actor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActorDTO {
    private Integer actorId;
    private String firstName;
    private String lastName;
    public ActorDTO(Actor actor) {
        this.actorId = actor.getActorId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
    }
}
