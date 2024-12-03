package com.talentoTechGrupo3.redComunitaria.users.repositories;

import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository<City,Long> {

}
