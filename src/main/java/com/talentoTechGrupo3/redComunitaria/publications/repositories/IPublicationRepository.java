package com.talentoTechGrupo3.redComunitaria.publications.repositories;

import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPublicationRepository extends CrudRepository<Publication,Long> {


    @Query(value = "SELECT * FROM publications p " +
            "LEFT JOIN entrepreneurships e ON p.id = e.id " +
            "LEFT JOIN events ev ON p.id = ev.id " +
            "WHERE p.type_publication = :type", nativeQuery = true)
    List<Publication> findByDiscriminator(@Param("type") String type);


}
