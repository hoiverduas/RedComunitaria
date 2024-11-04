package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.ResponseAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    ResponseAdminDTO createAdmin(RequestAdminDTO requestAdminDTO);
    List<ResponseAdminDTO> findAll();
    Optional<Admin> findById(Long id);
    Admin updateAdmin(Admin admin);
    void deleteAdminById(Long id);

}
