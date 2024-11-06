package com.talentoTechGrupo3.redComunitaria.publications.services;

import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.RequestEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;

public interface IEntrepreneurshipService {

    ResponseEntrepreneurshipDTO createEntrepreneurship(RequestEntrepreneurshipDTO requestEntrepreneurshipDTO);

}
