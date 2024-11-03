package com.talentoTechGrupo3.redComunitaria.dto;

import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.EventType;
import com.talentoTechGrupo3.redComunitaria.entities.reactioEntities.ReactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDTO {

    private String name;
    private String description;
    private LocalDateTime eventDate;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;
    private String duration;
    private String content;
    private Long userId;

}
