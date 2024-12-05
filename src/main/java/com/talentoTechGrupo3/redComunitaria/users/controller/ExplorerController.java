package com.talentoTechGrupo3.redComunitaria.users.controller;


import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.RequestExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.RequestExplorerUpdateDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.ResponseExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Explorer;
import com.talentoTechGrupo3.redComunitaria.users.services.impl.ExplorerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/explorers")
public class ExplorerController {

    private final ExplorerService explorerService;


    public ExplorerController(ExplorerService explorerService) {
        this.explorerService = explorerService;
    }

    @PostMapping
    public ResponseEntity<ResponseExplorerDTO> createExplorer(@RequestBody RequestExplorerDTO requestExplorerDTO){
       try {
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(this.explorerService.createExplorer(requestExplorerDTO));
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST).build();

       }
    }

    @GetMapping
    public ResponseEntity<List<ResponseExplorerDTO>> getAllExplorers(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.explorerService.findAllExplorer());
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseExplorerDTO> getExplorerById(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.explorerService.findExplorerById(id));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<ResponseExplorerDTO> update(@RequestBody RequestExplorerUpdateDTO requestExplorerUpdateDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.explorerService.updateExplorer(requestExplorerUpdateDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExplorerById(@PathVariable Long id){
         try {
             this.explorerService.deleteExplorerById(id);
             return ResponseEntity.status(HttpStatus.OK).build();
         }catch (RuntimeException e){
             return ResponseEntity
                     .status(HttpStatus.NOT_FOUND).build();
         }
    }

}
