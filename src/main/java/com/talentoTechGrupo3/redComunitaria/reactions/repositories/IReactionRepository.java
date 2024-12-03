package com.talentoTechGrupo3.redComunitaria.reactions.repositories;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.Reaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReactionRepository extends CrudRepository<Reaction,Long> {
}
