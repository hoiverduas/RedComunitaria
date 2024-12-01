package com.talentoTechGrupo3.redComunitaria.publications.services.impl;


import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IPublicationRepository;
import com.talentoTechGrupo3.redComunitaria.publications.services.IPublicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService implements IPublicationService {

    private  final IPublicationRepository publicationRepository;

    public PublicationService(IPublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public List<Publication> findByTypePublication(String type) {
        return this.publicationRepository.findByDiscriminator(type);
    }

    @Override
    public List<Publication> findAllPublications() {
        return (List<Publication>) this.publicationRepository.findAll();
    }
}
