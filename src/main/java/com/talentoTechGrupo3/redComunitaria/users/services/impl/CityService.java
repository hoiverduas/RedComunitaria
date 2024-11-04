package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestCityDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IDepartmentRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.ICityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    private final ICityRepository cityRepository;
    private final IDepartmentRepository departmentRepository;

    public CityService(ICityRepository cityRepository, IDepartmentRepository departmentRepository) {
        this.cityRepository = cityRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public City createCity( RequestCityDTO requestCityDTO) {

        Long departmentId = requestCityDTO.getDepartmentId();
        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(()->new RuntimeException("Not Found"));

        City city = new City();

        city.setNameCity(requestCityDTO.getNameCity());
        city.setDepartment(department);

        return this.cityRepository.save(city);
    }

    @Override
    public List<City> findAllCity() {
        return (List<City>) this.cityRepository.findAll();
    }

}
