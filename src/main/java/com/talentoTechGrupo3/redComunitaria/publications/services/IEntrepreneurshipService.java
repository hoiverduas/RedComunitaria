package com.talentoTechGrupo3.redComunitaria.publications.services;

import com.talentoTechGrupo3.redComunitaria.publications.dto.CreateEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;

public interface IEntrepreneurshipService {

    Entrepreneurship createEntrepreneurship(CreateEntrepreneurshipDTO createEntrepreneurshipDTO);

}
