package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.entities.Department;

import java.util.List;

public interface IDepartmentService {

    Department createDepartment(Department department);
    List<Department> findAllDepartment();

}
