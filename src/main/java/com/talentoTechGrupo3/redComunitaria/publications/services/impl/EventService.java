package com.talentoTechGrupo3.redComunitaria.publications.services.impl;

import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.RequestEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent.ResponseEventDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Event;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IEventRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.publications.services.IEventService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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

        ResponseEventDTO responseDTO = mapToDto(event);
        responseDTO.setUserId(userId);
        responseDTO.setEventDate(event.getEventDate());

        return responseDTO;


    }

    @Override
    public List<ResponseEventDTO> findAllEvent() {

        List<Event> events = (List<Event>) eventRepository.findAll();
        return events.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }


    private ResponseEventDTO mapToDto(Event event) {
        ResponseEventDTO dto = new ResponseEventDTO();
        dto.setId(event.getId());
        dto.setContent(event.getContent());
        dto.setEventDate(event.getEventDate());
        dto.setName(event.getName());
        dto.setDuration(event.getDuration());
        dto.setUserId(event.getUsers().getId());
        dto.setDescription(event.getDescription());
        dto.setEventType(event.getEventType());



        return dto;
    }

    private Event mapToEntity(RequestEventDTO requestEventDTO){
        return this.modelMapper
                .map(requestEventDTO,Event.class);
    }
}
