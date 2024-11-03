package com.talentoTechGrupo3.redComunitaria.entities.publicationEntities;


import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.Publication;
import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.TypeSector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrepreneurships")
@DiscriminatorValue("ENTREPRENEURSHIP")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entrepreneurship extends Publication {


    private String nameCompany;
    private LocalDateTime startDate;
    private Double receivedInvestment;
    @Enumerated(EnumType.STRING)
    private TypeSector typeSector;


}
