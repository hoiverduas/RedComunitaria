package com.talentoTechGrupo3.redComunitaria.users.controller;


import com.talentoTechGrupo3.redComunitaria.users.dto.RequestCityDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.services.impl.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody RequestCityDTO requestCityDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.cityService.createCity(requestCityDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCity(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.cityService.findAllCity());
    }

}
