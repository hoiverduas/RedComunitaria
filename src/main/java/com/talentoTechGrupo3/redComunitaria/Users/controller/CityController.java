package com.talentoTechGrupo3.redComunitaria.Users.controller;


import com.talentoTechGrupo3.redComunitaria.Users.entities.City;
import com.talentoTechGrupo3.redComunitaria.Users.services.impl.CityService;
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
    public ResponseEntity<City> createCity(@RequestBody City city){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.cityService.createCity(city));
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
