package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestDepartmentDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoDepartment.ResponseDepartmentDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;
import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IDepartmentRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(IDepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ResponseDepartmentDTO> createDepartment(List<RequestDepartmentDTO> requestDepartmentDTOList) {

        // Convertir la lista de DTOs a entidades
        List<Department> departments = requestDepartmentDTOList.stream()
                .map(this::mapToEntity)  // Mapea cada RequestDepartmentDTO a un Departamento
                .collect(Collectors.toList());

        // Guardar todos los departamentos en la base de datos
        departmentRepository.saveAll(departments);

        // Convertir las entidades guardadas de nuevo a DTOs y devolver la lista
        return departments.stream()
                .map(this::mapToDto)  // Mapea cada Departamento a un ResponseDepartmentDTO
                .collect(Collectors.toList());


    }

    @Override
    public List<ResponseDepartmentDTO> findAllDepartment() {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        return departments.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }


    private ResponseDepartmentDTO mapToDto(Department department){
        return this.modelMapper
                .map(department,ResponseDepartmentDTO.class);
    }

    private Department mapToEntity(RequestDepartmentDTO responseDepartmentDTO){
        return this.modelMapper
                .map(responseDepartmentDTO,Department.class);
    }

}
