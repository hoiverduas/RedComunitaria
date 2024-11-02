package com.talentoTechGrupo3.redComunitaria.services.impl;

import com.talentoTechGrupo3.redComunitaria.dto.CreateEventDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Event;
import com.talentoTechGrupo3.redComunitaria.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.entities.User;
import com.talentoTechGrupo3.redComunitaria.respositories.IEventRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.services.IEventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class EventService implements IEventService {

    private final IEventRepository eventRepository;

    private final IUserRepository userRepository;

    public EventService(IEventRepository eventRepository, IUserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Event createEvent(CreateEventDTO createEventDTO) {

        Long userId = createEventDTO.getUserId();
        User user =userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("Not Found"));

        Event event = new Event();
        event.setUsers(user);
        event.setEventType(createEventDTO.getEventType());
        event.setName(createEventDTO.getName());
        event.setDescription(createEventDTO.getDescription());
        event.setDuration(createEventDTO.getDuration());
        event.setContent(createEventDTO.getContent());
        event.setEventDate(LocalDateTime.now());

        return this.eventRepository.save(event);
    }
}
