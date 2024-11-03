package com.talentoTechGrupo3.redComunitaria.Users.dto;

import com.talentoTechGrupo3.redComunitaria.Users.entities.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEntrepreneurDTO {

    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean disabled;
    private String experience;
    private String contact;
    private String fullName;
    private Specialty specialty;

}
