package com.talentoTechGrupo3.redComunitaria.Users.services;

import com.talentoTechGrupo3.redComunitaria.Users.dto.RequestEntrepreneurDTO;
import com.talentoTechGrupo3.redComunitaria.Users.entities.Entrepreneur;

import java.util.List;
import java.util.Optional;

public interface IEntrepreneurService {

    Entrepreneur createEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO);
    List<Entrepreneur> findAllEntrepreneur();
    Optional<Entrepreneur> findByIdEntrepreneur(Long id);
    Entrepreneur updateEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO);
    void deleteEntrepreneurById(Long id);


}
