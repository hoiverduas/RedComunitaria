package com.talentoTechGrupo3.redComunitaria.Users.controller;


import com.talentoTechGrupo3.redComunitaria.Users.entities.Entrepreneur;
import com.talentoTechGrupo3.redComunitaria.Users.services.impl.EntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrepreneur")
public class EntrepreneurController {

    private final EntrepreneurService entrepreneurService;

    @Autowired
    public EntrepreneurController(EntrepreneurService entrepreneurService) {
        this.entrepreneurService = entrepreneurService;
    }

    @PostMapping
    public ResponseEntity<Entrepreneur> createEntrepreneur(@RequestBody Entrepreneur entrepreneur){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.entrepreneurService.createEntrepreneur(entrepreneur));
    }
    @GetMapping
    public ResponseEntity<List<Entrepreneur>> getEntrepreneurAll(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.entrepreneurService.findAllEntrepreneur());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Entrepreneur>> getEntrepreneur(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.entrepreneurService.findByIdEntrepreneur(id));
    }
    @PostMapping("/update")
    public ResponseEntity<Entrepreneur> updateEntrepreneur(@RequestBody Entrepreneur entrepreneur){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.entrepreneurService.updateEntrepreneur(entrepreneur));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Entrepreneur> deleteEntrepreneur(@PathVariable Long id){
        this.entrepreneurService.deleteEntrepreneurById(id);
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }
}
