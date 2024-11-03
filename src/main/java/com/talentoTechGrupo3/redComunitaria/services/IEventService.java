package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.dto.CreateEventDTO;
import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.Event;

public interface IEventService {
    Event createEvent(CreateEventDTO createEventDTO);
}
