package com.talentoTechGrupo3.redComunitaria.users.services;


import com.talentoTechGrupo3.redComunitaria.users.dto.cityDto.RequestCityDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.cityDto.ResponseCityDTO;


import java.util.List;

public interface ICityService {

    ResponseCityDTO createCity(RequestCityDTO requestCityDTO);
    List<ResponseCityDTO> findAllCity();

}
