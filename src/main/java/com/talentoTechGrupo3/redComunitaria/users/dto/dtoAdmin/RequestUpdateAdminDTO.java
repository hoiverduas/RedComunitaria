package com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin;


import com.talentoTechGrupo3.redComunitaria.users.entities.AreaOfResponsibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateAdminDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean disabled;
    private Integer accessLevel;
    private AreaOfResponsibility areaOfResponsibility;
    private Long cityId;

}
