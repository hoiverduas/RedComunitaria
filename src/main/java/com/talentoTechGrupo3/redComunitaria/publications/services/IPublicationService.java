package com.talentoTechGrupo3.redComunitaria.publications.services;

import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPublicationService {

    List<Publication> findByTypePublication(String type);
   List<Publication>findAllPublications();
}
