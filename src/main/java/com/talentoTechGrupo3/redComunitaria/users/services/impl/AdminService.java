package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IAdminRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final IAdminRepository adminRepository;
    private final ICityRepository cityRepository;

    @Autowired
    public AdminService(IAdminRepository adminRepository, ICityRepository cityRepository) {
        this.adminRepository = adminRepository;
        this.cityRepository = cityRepository;
    }


    @Override
    public Admin createAdmin(RequestAdminDTO requestAdminDTO) {

        Long cityId = requestAdminDTO.getCityId();
        City city = cityRepository
                .findById(cityId)
                .orElseThrow(()->new RuntimeException("Not Found"));

        Admin admin = new Admin();
        admin.setId(requestAdminDTO.getId());
        admin.setUsername(requestAdminDTO.getUsername());
        admin.setPassword(requestAdminDTO.getPassword());
        admin.setEmail(requestAdminDTO.getEmail());
        admin.setLocked(requestAdminDTO.getLocked());
        admin.setDisabled(requestAdminDTO.getDisabled());
        admin.setAccessLevel(requestAdminDTO.getAccessLevel());
        admin.setAreaOfResponsibility(requestAdminDTO.getAreaOfResponsibility());
        admin.setCities(city);

        return this.adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return (List<Admin>) this.adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return this.adminRepository
                .findById(id)
                .or(() -> {throw  new RuntimeException("Not Found");
                });
    }

    @Override
    public Admin updateAdmin(RequestAdminDTO requestAdminDTO) {

        Optional<Admin> optionalAdmin = findById(requestAdminDTO.getId());

        if (optionalAdmin.isPresent()){

            Admin existAdmin = optionalAdmin.get();

            existAdmin.setUsername(requestAdminDTO.getUsername());
            existAdmin.setPassword(requestAdminDTO.getPassword());
            existAdmin.setEmail(requestAdminDTO.getUsername());
            existAdmin.setDisabled(requestAdminDTO.getDisabled());
            existAdmin.setLocked(requestAdminDTO.getLocked());
            existAdmin.setAccessLevel(requestAdminDTO.getAccessLevel());
            existAdmin.setAreaOfResponsibility(requestAdminDTO.getAreaOfResponsibility());

            return this.adminRepository.save(existAdmin);
        }else {

            throw new RuntimeException("Not Found");
        }
    }

    @Override
    public void deleteAdminById(Long id) {

        Optional<Admin>optionalAdmin = findById(id);

        if (optionalAdmin.isPresent()){

            this.adminRepository.deleteById(id);

        }else {
            throw new RuntimeException("No found");
        }

    }
}
