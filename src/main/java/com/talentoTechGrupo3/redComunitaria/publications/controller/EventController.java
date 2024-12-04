package com.talentoTechGrupo3.redComunitaria.publications.controller;


import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.RequestEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.ResponseEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;
import com.talentoTechGrupo3.redComunitaria.publications.services.impl.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<ResponseEventDTO> createEvent(@RequestBody RequestEventDTO requestEventDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.eventService.createEvent(requestEventDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping
    public ResponseEntity<List<ResponseEventDTO>> getAllPublication(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.eventService.findAllEvent());
    }

}
