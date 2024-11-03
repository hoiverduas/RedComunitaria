package com.talentoTechGrupo3.redComunitaria.entities;


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
