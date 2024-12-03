package com.talentoTechGrupo3.redComunitaria.reactions.repositories;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.PublicationReaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicationReactionRepository extends CrudRepository<PublicationReaction,Long> {

    List<PublicationReaction> findByUserId(Long userId);

}
