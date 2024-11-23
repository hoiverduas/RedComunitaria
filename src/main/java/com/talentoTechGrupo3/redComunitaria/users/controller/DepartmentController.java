package com.talentoTechGrupo3.redComunitaria.users.controller;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestDepartmentDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoDepartment.ResponseDepartmentDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import com.talentoTechGrupo3.redComunitaria.users.services.impl.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ResponseDepartmentDTO> createDepartment(@RequestBody RequestDepartmentDTO requestDepartmentDTO){
       try {
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(this.departmentService.createDepartment(requestDepartmentDTO));
       }catch (RuntimeException e){
           return ResponseEntity.
                   status(HttpStatus.NOT_FOUND).build();
       }
    }

    @GetMapping
    public ResponseEntity<List<ResponseDepartmentDTO>> getAllDepartment(){
       return ResponseEntity
               .status(HttpStatus.NOT_FOUND)
               .body(this.departmentService.findAllDepartment());
    }

}
