package com.talentoTechGrupo3.redComunitaria.publications.services;

import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.RequestEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.ResponseEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;

import java.util.List;

public interface IEventService {
    ResponseEventDTO createEvent(RequestEventDTO requestEventDTO);
    List<ResponseEventDTO> findAllEvent();
}
