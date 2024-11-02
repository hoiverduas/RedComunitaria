package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.dto.CreateEventDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Event;

public interface IEventService {
    Event createEvent(CreateEventDTO createEventDTO);
}
