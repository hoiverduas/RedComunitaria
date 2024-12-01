package com.talentoTechGrupo3.redComunitaria.users.services;

import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestUpdateAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.ResponseAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    ResponseAdminDTO createAdmin(RequestAdminDTO requestAdminDTO);
    List<ResponseAdminDTO> findAllAdmin();
    Optional<ResponseAdminDTO> findById(Long id);
    ResponseAdminDTO updateAdmin(RequestUpdateAdminDTO requestUpdateAdminDTO);
    void deleteAdminById(Long id);

}
