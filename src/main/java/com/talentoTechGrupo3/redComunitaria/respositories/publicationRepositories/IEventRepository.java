package com.talentoTechGrupo3.redComunitaria.respositories.publicationRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.Event;
import org.springframework.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<Event,Long> {
}
