package com.talentoTechGrupo3.redComunitaria.publications.controller;


import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.publications.services.impl.PublicationService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationService publicationService;


    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }


    @GetMapping("/type")
    public ResponseEntity<List<Publication>> getPublicationByType(@RequestParam String type){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.publicationService.findByTypePublication(type));
    }


    @GetMapping
    public ResponseEntity<List<Publication>> gerAllPublication(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.publicationService.findAllPublications());
    }
}
