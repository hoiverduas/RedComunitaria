package com.talentoTechGrupo3.redComunitaria.users.dto.cityDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCityDTO {

    private Long idCity;
    private String nameCity;
    private Long departmentId;

}
