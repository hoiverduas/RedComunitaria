package com.talentoTechGrupo3.redComunitaria.Users.services;

import com.talentoTechGrupo3.redComunitaria.Users.entities.City;

import java.util.List;

public interface ICityService {

    City createCity(City city);
    List<City> findAllCity();

}
