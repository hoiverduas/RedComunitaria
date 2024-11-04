package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.ResponseAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.Admin;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IAdminRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IAdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService {

    private final IAdminRepository adminRepository;
    private final ICityRepository cityRepository;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public AdminService(IAdminRepository adminRepository, ICityRepository cityRepository, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.cityRepository = cityRepository;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseAdminDTO createAdmin(RequestAdminDTO requestAdminDTO) {
        Long cityId = requestAdminDTO.getCityId();
        City city = cityRepository
                .findById(cityId)
                .orElseThrow(()->new RuntimeException("Not Found"));

        Admin admin = mapToEntity(requestAdminDTO);
        admin.setCities(city);

        adminRepository.save(admin);

        ResponseAdminDTO responseAdminDTO = mapToDto(admin);
        responseAdminDTO.setCityId(cityId);

        return responseAdminDTO;

    }

    @Override
    public List<ResponseAdminDTO> findAll() {
        List<Admin> admins = (List<Admin>) adminRepository.findAll(); // Asegúrate de que el método devuelva una lista.
        return admins.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponseAdminDTO> findById(Long id) {
         Admin admin = adminRepository
                .findById(id)
                .orElseThrow(() -> {throw  new RuntimeException("Not Found");
                });
        return Optional.of(mapToDto(admin));
    }

    /*@Override
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
    }*/

   /* @Override
    public void deleteAdminById(Long id) {

        Optional<Admin>optionalAdmin = findById(id);

        if (optionalAdmin.isPresent()){

            this.adminRepository.deleteById(id);

        }else {
            throw new RuntimeException("No found");
        }

    }*/


    private ResponseAdminDTO mapToDto(Admin admin) {
        ResponseAdminDTO responseAdminDTO = this.modelMapper.map(admin, ResponseAdminDTO.class);
        if (admin.getCities() != null) {
            responseAdminDTO.setCityId(admin.getCities().getId()); // Asigna el ID de la ciudad manualmente
        }
        return responseAdminDTO;
    }

    private Admin mapToEntity(RequestAdminDTO requestAdminDTO){
        return this.modelMapper
                .map(requestAdminDTO,Admin.class);
    }


}
