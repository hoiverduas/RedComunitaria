package com.talentoTechGrupo3.redComunitaria.publications.repositories;

import com.talentoTechGrupo3.redComunitaria.publications.entities.PublicationReaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPublicationReactionRepository extends CrudRepository<PublicationReaction,Long> {

    List<PublicationReaction> findByUserId(Long userId);

}