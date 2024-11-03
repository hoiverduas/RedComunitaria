package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    Admin createAdmin(RequestAdminDTO requestAdminDTO);
    List<Admin> findAll();
    Optional<Admin> findById(Long id);
    Admin updateAdmin(RequestAdminDTO requestAdminDTO);
    void deleteAdminById(Long id);

}
