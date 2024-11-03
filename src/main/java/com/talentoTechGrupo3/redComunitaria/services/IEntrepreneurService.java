package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.entities.userEntities.Entrepreneur;

import java.util.List;
import java.util.Optional;

public interface IEntrepreneurService {

    Entrepreneur createEntrepreneur(Entrepreneur entrepreneur);
    List<Entrepreneur> findAllEntrepreneur();
    Optional<Entrepreneur> findByIdEntrepreneur(Long id);
    Entrepreneur updateEntrepreneur(Entrepreneur entrepreneur);
    void deleteEntrepreneurById(Long id);


}
