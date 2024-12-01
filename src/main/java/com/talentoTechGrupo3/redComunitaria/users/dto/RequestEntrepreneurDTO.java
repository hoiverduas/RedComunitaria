package com.talentoTechGrupo3.redComunitaria.users.dto;

import com.talentoTechGrupo3.redComunitaria.users.entities.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEntrepreneurDTO {

    private  Long id;
    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean disabled;
    private String experience;
    private String contact;
    private String fullName;
    private Specialty specialty;
    private String roles;
    private Long cityId;

}
