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
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.explorerService.createExplorer(requestExplorerDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseExplorerDTO>> getAllExplorers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.explorerService.findAllExplorer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseExplorerDTO> getExplorerById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.explorerService.findExplorerById(id));
    }

    @PutMapping
    public ResponseEntity<ResponseExplorerDTO> update(@RequestBody RequestExplorerUpdateDTO requestExplorerUpdateDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.explorerService.updateExplorer(requestExplorerUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExplorerById(@PathVariable Long id){
          this.explorerService.deleteExplorerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
