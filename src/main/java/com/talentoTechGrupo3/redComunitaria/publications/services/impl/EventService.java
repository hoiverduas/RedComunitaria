package com.talentoTechGrupo3.redComunitaria.publications.services.impl;

import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.RequestEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.ResponseEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IEventRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.publications.services.IEventService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class EventService implements IEventService {

    private final IEventRepository eventRepository;

    private final IUserRepository userRepository;

    private final ModelMapper modelMapper;

    public EventService(IEventRepository eventRepository, IUserRepository userRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEventDTO createEvent(RequestEventDTO requestEventDTO) {

        Long userId = requestEventDTO.getUserId();
        User user =userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("Not Found"));

        Event event = mapToEntity(requestEventDTO);
        event.setId(null);
        event.setEventDate(LocalDateTime.now());
        event.setUsers(user);

        eventRepository.save(event);

        ResponseEventDTO responseDTO = mapTaDto(event);
        responseDTO.setUserId(userId);
        responseDTO.setEventDate(event.getEventDate());

        return responseDTO;


    }

    private ResponseEventDTO mapTaDto(Event event){
        return this.modelMapper
                .map(event,ResponseEventDTO.class);
    }

    private Event mapToEntity(RequestEventDTO requestEventDTO){
        return this.modelMapper
                .map(requestEventDTO,Event.class);
    }
}
