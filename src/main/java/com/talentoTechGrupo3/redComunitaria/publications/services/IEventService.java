package com.talentoTechGrupo3.redComunitaria.publications.services;

import com.talentoTechGrupo3.redComunitaria.publications.dto.CreateEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;

public interface IEventService {
    Event createEvent(CreateEventDTO createEventDTO);
}
