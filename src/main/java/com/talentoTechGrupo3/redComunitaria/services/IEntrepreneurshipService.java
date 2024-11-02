package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.dto.CreateEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Entrepreneurship;

public interface IEntrepreneurshipService {

    Entrepreneurship createEntrepreneurship(CreateEntrepreneurshipDTO createEntrepreneurshipDTO);

}
