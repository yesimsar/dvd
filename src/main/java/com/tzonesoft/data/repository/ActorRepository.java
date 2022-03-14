package com.tzonesoft.data.repository;

import com.tzonesoft.data.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
//    @Query(value = "SELECT * FROM actor Where name:=?",nativeQuery = true)
    @Query(value = "SELECT a FROM Actor a Where a.firstName=:name")
    Actor getByName(String name);

    Actor findOneByFirstName(String firstName);
}
