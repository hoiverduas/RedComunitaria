package com.talentoTechGrupo3.redComunitaria.respositories;

import com.talentoTechGrupo3.redComunitaria.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<Event,Long> {
}
