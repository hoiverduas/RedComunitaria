package com.talentoTechGrupo3.redComunitaria.entities.publicationEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@DiscriminatorValue("EVENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends Publication {


    private String name;
    private String description;
    private LocalDateTime eventDate;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private String duration;



}
