package com.talentoTechGrupo3.redComunitaria.controller;

import com.talentoTechGrupo3.redComunitaria.entities.Admin;
import com.talentoTechGrupo3.redComunitaria.services.impl.AdminService;
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
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.adminService.createAdmin(admin));
    }
    @GetMapping
    public ResponseEntity<List<Admin>> getAdminAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.adminService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Admin>> getAdminById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.adminService.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.adminService.updateAdmin(admin));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Admin> deleteAdminById(@PathVariable Long id){
         this.adminService.deleteAdminById(id);
         return ResponseEntity
                 .status(HttpStatus.OK).build();
    }

}
