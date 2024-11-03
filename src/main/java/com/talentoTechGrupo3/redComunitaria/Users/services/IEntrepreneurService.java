package com.talentoTechGrupo3.redComunitaria.Users.services;

import com.talentoTechGrupo3.redComunitaria.Users.entities.Entrepreneur;

import java.util.List;
import java.util.Optional;

public interface IEntrepreneurService {

    Entrepreneur createEntrepreneur(Entrepreneur entrepreneur);
    List<Entrepreneur> findAllEntrepreneur();
    Optional<Entrepreneur> findByIdEntrepreneur(Long id);
    Entrepreneur updateEntrepreneur(Entrepreneur entrepreneur);
    void deleteEntrepreneurById(Long id);


}
