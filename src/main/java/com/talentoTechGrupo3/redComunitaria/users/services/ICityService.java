package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestCityDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;

import java.util.List;

public interface ICityService {

    City createCity(RequestCityDTO requestCityDTO);
    List<City> findAllCity();

}
