package com.talentoTechGrupo3.redComunitaria.users.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DiscriminatorValue("EXPLORER")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "explorers")
public class Explorer extends User{

    private String fullName;
    private String contact;

}
