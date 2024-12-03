package com.talentoTechGrupo3.redComunitaria.users.services.impl;


import com.talentoTechGrupo3.redComunitaria.users.dto.cityDto.RequestCityDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.cityDto.ResponseCityDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IDepartmentRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.ICityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService implements ICityService {

    private final ICityRepository cityRepository;
    private final IDepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public CityService(ICityRepository cityRepository, IDepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ResponseCityDTO> createCity(List<RequestCityDTO> requestCityDTOs) {

        List<ResponseCityDTO> responseCityDTOs = new ArrayList<>();

        // Iteramos sobre la lista de RequestCityDTO
        for (RequestCityDTO requestCityDTO : requestCityDTOs) {

            Long departmentId = requestCityDTO.getDepartmentId();

            // Buscar el departamento
            Department department = departmentRepository
                    .findById(departmentId)
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

            // Crear la ciudad
            City city = mapToEntity(requestCityDTO);
            city.setIdCity(null);  // Asegurarse de que el ID se auto-incremente
            city.setDepartment(department);  // Asignar el departamento

            // Guardar la ciudad
            cityRepository.save(city);

            // Crear el ResponseCityDTO y agregarlo a la lista
            ResponseCityDTO responseCityDTO = mapToDto(city);
            responseCityDTO.setDepartmentId(department.getId());

            responseCityDTOs.add(responseCityDTO);
        }

        return responseCityDTOs;  // Retornar la lista de ciudades creadas
    }

    @Override
    public List<ResponseCityDTO> findAllCity() {
        List<City>cities = (List<City>) cityRepository.findAll();
        return cities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ResponseCityDTO mapToDto(City city){
        return this.modelMapper
                .map(city,ResponseCityDTO.class);
    }

    private City mapToEntity(RequestCityDTO requestCityDTO){
        return this.modelMapper
                .map(requestCityDTO,City.class);
    }

}
