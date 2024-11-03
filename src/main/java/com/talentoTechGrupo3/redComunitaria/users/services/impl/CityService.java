package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.ICityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    private final ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public City createCity(City city) {
        return this.cityRepository.save(city);
    }

    @Override
    public List<City> findAllCity() {
        return (List<City>) this.cityRepository.findAll();
    }

}
