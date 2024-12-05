package com.talentoTechGrupo3.redComunitaria.publications.controller;


import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.RequestEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.publications.services.impl.EntrepreneurshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrepreneurShip")
public class EntrepreneurshipController {

    private final EntrepreneurshipService entrepreneurshipService;

    public EntrepreneurshipController(EntrepreneurshipService entrepreneurshipService) {
        this.entrepreneurshipService = entrepreneurshipService;
    }

    @PostMapping
    public ResponseEntity<ResponseEntrepreneurshipDTO> createEntrepreneurship(@RequestBody RequestEntrepreneurshipDTO requestEntrepreneurshipDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.entrepreneurshipService.createEntrepreneurship(requestEntrepreneurshipDTO));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable Long id){

        try {
            this.entrepreneurshipService.deletePublication(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<ResponseEntrepreneurshipDTO>> getAllPublication(){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.entrepreneurshipService.findAllEntrepreneurship());
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        }
    }

}
