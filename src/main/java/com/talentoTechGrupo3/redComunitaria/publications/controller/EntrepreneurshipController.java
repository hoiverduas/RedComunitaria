package com.talentoTechGrupo3.redComunitaria.publications.controller;


import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.RequestEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.publications.services.impl.EntrepreneurshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
