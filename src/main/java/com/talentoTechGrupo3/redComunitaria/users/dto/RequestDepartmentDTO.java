package com.talentoTechGrupo3.redComunitaria.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDepartmentDTO {

    private String nameDepartment;
    private List<String> cityNames;

}
