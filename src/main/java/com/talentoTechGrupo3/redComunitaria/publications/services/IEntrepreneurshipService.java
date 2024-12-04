package com.talentoTechGrupo3.redComunitaria.publications.services;

import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.RequestEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;

import java.util.List;

public interface IEntrepreneurshipService {

    ResponseEntrepreneurshipDTO createEntrepreneurship(RequestEntrepreneurshipDTO requestEntrepreneurshipDTO);
    String deletePublication(Long id);
    ResponseEntrepreneurshipDTO findPublicationById(Long id);
    List<ResponseEntrepreneurshipDTO> findAllEntrepreneurship();
}
