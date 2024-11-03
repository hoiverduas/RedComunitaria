package com.talentoTechGrupo3.redComunitaria.publications.repositories;

import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<Event,Long> {
}
