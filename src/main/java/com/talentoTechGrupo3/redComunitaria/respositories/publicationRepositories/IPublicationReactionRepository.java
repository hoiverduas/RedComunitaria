package com.talentoTechGrupo3.redComunitaria.respositories.publicationRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.PublicationReaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPublicationReactionRepository extends CrudRepository<PublicationReaction,Long> {

    List<PublicationReaction> findByUserId(Long userId);

}
