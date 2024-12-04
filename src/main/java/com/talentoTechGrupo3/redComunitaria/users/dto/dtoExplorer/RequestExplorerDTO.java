package com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer;


import lombok.Data;

@Data
public class RequestExplorerDTO {

    private String username;
    private String password;
    private String email;
    private String fullName;
    private String contact;
    private Boolean locked;
    private Boolean disabled;
    private Long cityId;

}
