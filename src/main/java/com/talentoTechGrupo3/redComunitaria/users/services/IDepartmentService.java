package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestDepartmentDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoDepartment.ResponseDepartmentDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Department;

import java.util.List;

public interface IDepartmentService {

    ResponseDepartmentDTO createDepartment(RequestDepartmentDTO requestDepartmentDTO);
    List<ResponseDepartmentDTO> findAllDepartment();

}
