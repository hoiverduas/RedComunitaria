package com.talentoTechGrupo3.redComunitaria.users.services.impl;


import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.RequestExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.RequestExplorerUpdateDTO;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoExplorer.ResponseExplorerDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.entities.Explorer;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IExplorerRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IExplorerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExplorerService implements IExplorerService {

    private final IExplorerRepository explorerRepository;
    private final ICityRepository cityRepository;
    private final PasswordEncoder passwordEncoder;

    public ExplorerService(IExplorerRepository explorerRepository, ICityRepository cityRepository, PasswordEncoder passwordEncoder) {
        this.explorerRepository = explorerRepository;
        this.cityRepository = cityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseExplorerDTO createExplorer(RequestExplorerDTO requestExplorerDTO) {

        Long cityId = requestExplorerDTO.getCityId();
        City city = cityRepository
                .findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found"));

        Explorer explorer = mapToEntity(requestExplorerDTO);
        explorer.setPassword(passwordEncoder.encode(explorer.getPassword()));
        explorer.setId(null);
        explorer.setCities(city);

        explorer = explorerRepository.save(explorer);

        ResponseExplorerDTO explorerDTO = mapToDto(explorer);
        explorerDTO.setRole(explorer.getRole());
        explorerDTO.setCityId(cityId);

        return explorerDTO;
    }

    @Override
    public List<ResponseExplorerDTO> findAllExplorer() {

        List<Explorer> explorers = (List<Explorer>) explorerRepository.findAll();
        return explorers.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseExplorerDTO findExplorerById(Long id) {
        Explorer explorer = explorerRepository.findById(id).orElseThrow(()->new RuntimeException("No found"));
        return mapToDto(explorer);
    }

    @Override
    public ResponseExplorerDTO updateExplorer(RequestExplorerUpdateDTO requestExplorerUpdateDTO) {
                   findExplorerById(requestExplorerUpdateDTO.getId());
                   Explorer explorer = explorerRepository.save(mapToEntity(requestExplorerUpdateDTO));
        return mapToDto(explorer) ;
    }

    @Override
    public String deleteExplorerById(Long id) {
              findExplorerById(id);
              this.explorerRepository.deleteById(id);
        return "usuario explorador con id"+ id +"fue eliminado exitosamente";
    }



    private ResponseExplorerDTO mapToDto(Explorer explorer) {
        ResponseExplorerDTO dto = new ResponseExplorerDTO ();
        dto.setId(explorer.getId());
        dto.setContact(explorer.getContact());
        dto.setFullName(explorer.getFullName());
        dto.setUsername(explorer.getUsername());
        dto.setEmail(explorer.getEmail());
        dto.setPassword(explorer.getPassword());
        dto.setDisabled(explorer.getDisabled());
        dto.setLocked(explorer.getLocked());
        dto.setCityId(explorer.getCities() != null ? explorer.getCities().getIdCity() : null);
        dto.setRole(explorer.getRole());
        return dto;
    }

    private Explorer mapToEntity(RequestExplorerDTO requestExplorerDTO) {
        Explorer explorerEntity = new Explorer ();
        explorerEntity.setContact(requestExplorerDTO.getContact());
        explorerEntity.setFullName(requestExplorerDTO.getFullName());
        explorerEntity.setUsername(requestExplorerDTO.getUsername());
        explorerEntity.setEmail(requestExplorerDTO.getEmail());
        explorerEntity.setPassword(requestExplorerDTO.getPassword());
        explorerEntity.setDisabled(requestExplorerDTO.getDisabled());
        explorerEntity.setLocked(requestExplorerDTO.getLocked());
        return explorerEntity;
    }

    private Explorer mapToEntity(RequestExplorerUpdateDTO requestExplorerUpdateDTO) {
        Explorer explorerEntity = new Explorer ();
        explorerEntity.setContact(requestExplorerUpdateDTO.getContact());
        explorerEntity.setFullName(requestExplorerUpdateDTO.getFullName());
        explorerEntity.setUsername(requestExplorerUpdateDTO.getUsername());
        explorerEntity.setEmail(requestExplorerUpdateDTO.getEmail());
        explorerEntity.setPassword(requestExplorerUpdateDTO.getPassword());
        explorerEntity.setDisabled(requestExplorerUpdateDTO.getDisabled());
        explorerEntity.setLocked(requestExplorerUpdateDTO.getLocked());
        return explorerEntity;
    }
}
