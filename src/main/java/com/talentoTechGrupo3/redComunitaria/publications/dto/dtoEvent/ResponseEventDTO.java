package com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEvent;

import com.talentoTechGrupo3.redComunitaria.publications.entities.EventType;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseEventDTO {

    private Long id;
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
