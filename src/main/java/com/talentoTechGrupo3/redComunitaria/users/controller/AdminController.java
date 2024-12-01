package com.talentoTechGrupo3.redComunitaria.users.controller;

import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestUpdateAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.ResponseAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;
import com.talentoTechGrupo3.redComunitaria.users.services.impl.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<ResponseAdminDTO> createAdmin(@RequestBody RequestAdminDTO requestAdminDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.adminService.createAdmin(requestAdminDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseAdminDTO>> getAdminAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.adminService.findAllAdmin());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ResponseAdminDTO>> getAdminById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.adminService.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseAdminDTO> updateAdmin(@RequestBody RequestUpdateAdminDTO requestUpdateAdminDTO){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.adminService.updateAdmin(requestUpdateAdminDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAdminById(@PathVariable Long id){
         this.adminService.deleteAdminById(id);
         return ResponseEntity
                 .status(HttpStatus.OK).build();
    }

}
