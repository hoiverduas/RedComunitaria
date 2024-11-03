package com.talentoTechGrupo3.redComunitaria.respositories.publicationRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.Publication;
import org.springframework.data.repository.CrudRepository;

public interface IPublicationRepository extends CrudRepository<Publication,Long> {
}
