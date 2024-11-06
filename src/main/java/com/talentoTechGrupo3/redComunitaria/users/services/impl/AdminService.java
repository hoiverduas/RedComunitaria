package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.RequestUpdateAdminDTO;
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
                .orElseThrow(() -> new RuntimeException("City not found"));

        Admin admin = mapToEntity(requestAdminDTO);
        admin.setId(null);
        admin.setCities(city);

        admin = adminRepository.save(admin);


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

    @Override
    public ResponseAdminDTO updateAdmin(RequestUpdateAdminDTO requestUpdateAdminDTO) {
               findById(requestUpdateAdminDTO.getId());
                Admin admin = adminRepository.save(mapToEntity(requestUpdateAdminDTO));
               return mapToDto(admin);

    }

    @Override
    public void deleteAdminById(Long id) {
        findById(id);
        adminRepository.deleteById(id);
    }


    private ResponseAdminDTO mapToDto(Admin admin) {
        return this.modelMapper.map(admin, ResponseAdminDTO.class);
    }

    private Admin mapToEntity(RequestAdminDTO requestAdminDTO){
        return this.modelMapper
                .map(requestAdminDTO,Admin.class);
    }

    private Admin mapToEntity(RequestUpdateAdminDTO requestUpdateAdminDTO){
        return this.modelMapper
                .map(requestUpdateAdminDTO,Admin.class);
    }

}
