package com.talentoTechGrupo3.redComunitaria.controller;


import com.talentoTechGrupo3.redComunitaria.dto.CreateEventDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Event;
import com.talentoTechGrupo3.redComunitaria.services.impl.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody CreateEventDTO createEventDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.eventService.createEvent(createEventDTO));
        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }

    }

}
