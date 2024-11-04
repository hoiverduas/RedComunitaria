package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IDepartmentRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        return (List<Department>) this.departmentRepository.findAll();
    }
}
