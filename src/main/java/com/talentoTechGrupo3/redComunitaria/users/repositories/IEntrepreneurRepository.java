package com.talentoTechGrupo3.redComunitaria.users.repositories;

import com.talentoTechGrupo3.redComunitaria.users.entities.Entrepreneur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrepreneurRepository extends CrudRepository<Entrepreneur,Long> {

}
