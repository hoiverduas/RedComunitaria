package com.talentoTechGrupo3.redComunitaria.services.impl;

import com.talentoTechGrupo3.redComunitaria.entities.userEntities.Admin;
import com.talentoTechGrupo3.redComunitaria.respositories.userRepositories.IAdminRepository;
import com.talentoTechGrupo3.redComunitaria.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final IAdminRepository adminRepository;

    @Autowired
    public AdminService(IAdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public Admin createAdmin(Admin admin) {
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
    public Admin updateAdmin(Admin admin) {

        Optional<Admin> optionalAdmin = findById(admin.getId());

        if (optionalAdmin.isPresent()){

            Admin existAdmin = optionalAdmin.get();

            existAdmin.setUsername(admin.getUsername());
            existAdmin.setPassword(admin.getPassword());
            existAdmin.setEmail(admin.getUsername());
            existAdmin.setDisabled(admin.getDisabled());
            existAdmin.setLocked(admin.getLocked());
            existAdmin.setAccessLevel(admin.getAccessLevel());
            existAdmin.setAreaOfResponsibility(admin.getAreaOfResponsibility());

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
