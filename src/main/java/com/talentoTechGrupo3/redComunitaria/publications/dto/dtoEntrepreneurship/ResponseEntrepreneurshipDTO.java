package com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship;

import com.talentoTechGrupo3.redComunitaria.publications.entities.TypeSector;
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
public class ResponseEntrepreneurshipDTO {

    private Long id;
    private String nameCompany;
    private LocalDateTime startDate;
    private Double receivedInvestment;
    private TypeSector typeSector;
    private String content;
    private ReactionType reactionType;
    private Long userId;

}
