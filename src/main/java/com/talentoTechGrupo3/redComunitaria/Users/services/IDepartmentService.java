package com.talentoTechGrupo3.redComunitaria.Users.services;

import com.talentoTechGrupo3.redComunitaria.Users.entities.Department;

import java.util.List;

public interface IDepartmentService {

    Department createDepartment(Department department);
    List<Department> findAllDepartment();

}
