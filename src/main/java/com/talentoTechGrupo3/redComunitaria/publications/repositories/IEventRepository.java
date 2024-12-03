package com.talentoTechGrupo3.redComunitaria.publications.repositories;

import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends CrudRepository<Event,Long> {
}
