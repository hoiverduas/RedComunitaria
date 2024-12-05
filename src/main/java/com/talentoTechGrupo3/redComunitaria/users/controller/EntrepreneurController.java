package com.talentoTechGrupo3.redComunitaria.users.controller;


import com.talentoTechGrupo3.redComunitaria.users.dto.RequestEntrepreneurDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Entrepreneur;
import com.talentoTechGrupo3.redComunitaria.users.services.impl.EntrepreneurService;
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
    public ResponseEntity<RequestEntrepreneurDTO> createEntrepreneur(@RequestBody RequestEntrepreneurDTO requestEntrepreneurDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.entrepreneurService.createEntrepreneur(requestEntrepreneurDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping
    public ResponseEntity<List<RequestEntrepreneurDTO>> getEntrepreneurAll(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.entrepreneurService.findAllEntrepreneur());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RequestEntrepreneurDTO>> getEntrepreneur(@PathVariable Long id){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(this.entrepreneurService.findByIdEntrepreneur(id));
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();
       }
    }


    @PutMapping("/update")
    public ResponseEntity<RequestEntrepreneurDTO> updateEntrepreneur(@RequestBody RequestEntrepreneurDTO requestEntrepreneurDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.entrepreneurService.updateEntrepreneur(requestEntrepreneurDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntrepreneur(@PathVariable Long id){
       try {
           this.entrepreneurService.deleteEntrepreneurById(id);
           return ResponseEntity
                   .status(HttpStatus.OK).build();
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();
       }
    }
}
