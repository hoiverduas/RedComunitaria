package com.talentoTechGrupo3.redComunitaria.Users.dto;

import com.talentoTechGrupo3.redComunitaria.Users.entities.AreaOfResponsibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAdminDTO {

    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean disabled;
    private Integer accessLevel;
    private AreaOfResponsibility areaOfResponsibility;
    private Long cityId;

}
