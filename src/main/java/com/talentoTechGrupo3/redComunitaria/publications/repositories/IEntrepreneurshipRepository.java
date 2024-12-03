package com.talentoTechGrupo3.redComunitaria.publications.repositories;

import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntrepreneurshipRepository extends CrudRepository<Entrepreneurship,Long> {

}
