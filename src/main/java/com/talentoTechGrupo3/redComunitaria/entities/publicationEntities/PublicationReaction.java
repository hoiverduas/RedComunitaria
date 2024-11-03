package com.talentoTechGrupo3.redComunitaria.entities.publicationEntities;


import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.Publication;
import com.talentoTechGrupo3.redComunitaria.entities.reactioEntities.Reaction;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PUBLICATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationReaction extends Reaction {

    @ManyToOne(optional = false)
    private Publication publication;

}
