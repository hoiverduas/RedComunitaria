package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestEntrepreneurDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Entrepreneur;

import java.util.List;
import java.util.Optional;

public interface IEntrepreneurService {

    RequestEntrepreneurDTO createEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO);
    List<RequestEntrepreneurDTO> findAllEntrepreneur();
    Optional<RequestEntrepreneurDTO> findByIdEntrepreneur(Long id);
    RequestEntrepreneurDTO updateEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO);
    void deleteEntrepreneurById(Long id);


}
