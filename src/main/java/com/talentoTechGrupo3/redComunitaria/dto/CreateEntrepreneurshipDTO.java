package com.talentoTechGrupo3.redComunitaria.dto;

import com.talentoTechGrupo3.redComunitaria.entities.reactioEntities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.TypeSector;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEntrepreneurshipDTO {

    private String nameCompany;
    private LocalDateTime startDate;
    private Double receivedInvestment;
    @Enumerated(EnumType.STRING)
    private TypeSector typeSector;
    private String content;
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;
    private Long userId;

}
