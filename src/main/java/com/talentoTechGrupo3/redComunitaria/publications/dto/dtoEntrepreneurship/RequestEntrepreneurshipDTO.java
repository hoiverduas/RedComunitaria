package com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.publications.entities.TypeSector;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEntrepreneurshipDTO {

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
