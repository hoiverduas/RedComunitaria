package com.talentoTechGrupo3.redComunitaria.users.repositories;

import com.talentoTechGrupo3.redComunitaria.users.entities.Explorer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExplorerRepository extends CrudRepository<Explorer,Long> {
}
