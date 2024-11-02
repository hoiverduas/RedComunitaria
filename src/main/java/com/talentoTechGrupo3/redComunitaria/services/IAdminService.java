package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    Admin createAdmin(Admin admin);
    List<Admin> findAll();
    Optional<Admin> findById(Long id);
    Admin updateAdmin(Admin admin);
    void deleteAdminById(Long id);

}
