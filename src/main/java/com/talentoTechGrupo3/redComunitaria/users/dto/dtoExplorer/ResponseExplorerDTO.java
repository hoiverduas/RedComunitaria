package com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer;

import com.talentoTechGrupo3.redComunitaria.users.entities.AreaOfResponsibility;
import lombok.Data;

@Data
public class ResponseExplorerDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String contact;
    private Boolean locked;
    private Boolean disabled;
    private String role;
    private Long cityId;
}
