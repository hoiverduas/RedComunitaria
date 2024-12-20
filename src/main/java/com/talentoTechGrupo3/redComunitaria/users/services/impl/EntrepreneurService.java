package com.talentoTechGrupo3.redComunitaria.users.services.impl;

import com.talentoTechGrupo3.redComunitaria.users.dto.RequestEntrepreneurDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.City;
import com.talentoTechGrupo3.redComunitaria.users.entities.Entrepreneur;
import com.talentoTechGrupo3.redComunitaria.users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IEntrepreneurRepository;
import com.talentoTechGrupo3.redComunitaria.users.services.IEntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EntrepreneurService implements IEntrepreneurService {

    private final IEntrepreneurRepository entrepreneurRepository;
    private final ICityRepository cityRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public EntrepreneurService(IEntrepreneurRepository entrepreneurRepository, ICityRepository cityRepository, PasswordEncoder passwordEncoder) {
        this.entrepreneurRepository = entrepreneurRepository;
        this.cityRepository = cityRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public RequestEntrepreneurDTO createEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO) {

        Long cityId = requestEntrepreneurDTO.getCityId();
        City city = cityRepository
                .findById(cityId)
                .orElseThrow(()->new RuntimeException("Not Found"));



        Entrepreneur entrepreneur = new Entrepreneur();

        if (entrepreneurRepository.existsByEmailAndPasswordAndUsernameAndFullName(
                entrepreneur.getUsername(),
                entrepreneur.getEmail(),
                entrepreneur.getPassword(),
                entrepreneur.getFullName())) {
            throw new RuntimeException("Ya existe un usuario con estos datos.");
        }

        entrepreneur.setId(requestEntrepreneurDTO.getId());
        entrepreneur.setUsername(requestEntrepreneurDTO.getUsername());
        entrepreneur.setPassword(passwordEncoder.encode(requestEntrepreneurDTO.getPassword()));
        entrepreneur.setEmail(requestEntrepreneurDTO.getEmail());
        entrepreneur.setLocked(requestEntrepreneurDTO.getLocked());
        entrepreneur.setDisabled(requestEntrepreneurDTO.getDisabled());
        entrepreneur.setExperience(requestEntrepreneurDTO.getExperience());
        entrepreneur.setContact(requestEntrepreneurDTO.getContact());
        entrepreneur.setFullName(requestEntrepreneurDTO.getFullName());
        entrepreneur.setSpecialty(requestEntrepreneurDTO.getSpecialty());
        entrepreneur.setCities(city);

        entrepreneurRepository.save(entrepreneur);

        RequestEntrepreneurDTO responseDTO = new RequestEntrepreneurDTO();

        responseDTO.setId(entrepreneur.getId());
        responseDTO.setUsername(entrepreneur.getUsername());
        responseDTO.setPassword(entrepreneur.getPassword());
        responseDTO.setEmail(entrepreneur.getEmail());
        responseDTO.setLocked(false);
        responseDTO.setDisabled(false);
        responseDTO.setExperience(entrepreneur.getExperience());
        responseDTO.setContact(entrepreneur.getContact());
        responseDTO.setFullName(entrepreneur.getFullName());
        responseDTO.setSpecialty(entrepreneur.getSpecialty());
        responseDTO.setRoles(entrepreneur.getRole());
        responseDTO.setCityId(city.getIdCity());

        return responseDTO;

    }

    @Override
    public List<RequestEntrepreneurDTO> findAllEntrepreneur() {

        List<Entrepreneur>entrepreneurs = (List<Entrepreneur>) entrepreneurRepository.findAll();

        List<RequestEntrepreneurDTO>requestEntrepreneurDTOS = new ArrayList<>();

        for (Entrepreneur entrepreneur: entrepreneurs) {

            Long cityId = (entrepreneur.getCities() != null) ? entrepreneur.getCities().getIdCity() : null;

            requestEntrepreneurDTOS.add(new RequestEntrepreneurDTO(entrepreneur.getId(),
                    entrepreneur.getUsername(),
                    entrepreneur.getPassword(),
                    entrepreneur.getEmail(),
                    entrepreneur.getLocked(),
                    entrepreneur.getDisabled(),
                    entrepreneur.getExperience(),
                    entrepreneur.getContact(),
                    entrepreneur.getFullName(),
                    entrepreneur.getSpecialty(),
                    entrepreneur.getRole(),
                    cityId ));
        }

        return requestEntrepreneurDTOS;
    }

    @Override
    public Optional<RequestEntrepreneurDTO> findByIdEntrepreneur(Long id) {

        Optional<Entrepreneur>optionalEntrepreneur =  entrepreneurRepository.findById(id);

        Optional<RequestEntrepreneurDTO> requestEntrepreneurDTO = null;

        if (optionalEntrepreneur.isPresent()){

            Entrepreneur existEntrepreneur = optionalEntrepreneur.get();

            Long cityId = (existEntrepreneur.getCities() != null) ? existEntrepreneur.getCities().getIdCity() : null;

            RequestEntrepreneurDTO requestDTO = new RequestEntrepreneurDTO();

            requestDTO.setCityId(cityId);
            requestDTO.setEmail(existEntrepreneur.getEmail());
            requestDTO.setLocked(existEntrepreneur.getLocked());
            requestDTO.setDisabled(existEntrepreneur.getDisabled());
            requestDTO.setId(existEntrepreneur.getId());
            requestDTO.setFullName(existEntrepreneur.getFullName());
            requestDTO.setSpecialty(existEntrepreneur.getSpecialty());
            requestDTO.setContact(existEntrepreneur.getContact());
            requestDTO.setUsername(existEntrepreneur.getUsername());
            requestDTO.setPassword(existEntrepreneur.getPassword());
            requestDTO.setExperience(existEntrepreneur.getExperience());
            requestDTO.setRoles(existEntrepreneur.getRole());
            requestEntrepreneurDTO = Optional.of(requestDTO);

            return requestEntrepreneurDTO;

        }else {
            throw new RuntimeException("Not Found");
        }

    }

    @Override
    public RequestEntrepreneurDTO updateEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO) {

        Long cityId = requestEntrepreneurDTO.getCityId();
        City city = cityRepository
                .findById(cityId)
                .orElseThrow(()->new RuntimeException("Not Found"));

             if (entrepreneurRepository.findById(requestEntrepreneurDTO.getId()).isPresent()){

                 Optional<Entrepreneur> entrepreneur = entrepreneurRepository.findById(requestEntrepreneurDTO.getId());

                 entrepreneur.get().setId(requestEntrepreneurDTO.getId());
                 entrepreneur.get().setUsername(requestEntrepreneurDTO.getUsername());
                 entrepreneur.get().setPassword(requestEntrepreneurDTO.getPassword());
                 entrepreneur.get().setEmail(requestEntrepreneurDTO.getEmail());
                 entrepreneur.get().setLocked(requestEntrepreneurDTO.getLocked());
                 entrepreneur.get().setDisabled(requestEntrepreneurDTO.getDisabled());
                 entrepreneur.get().setExperience(requestEntrepreneurDTO.getExperience());
                 entrepreneur.get().setContact(requestEntrepreneurDTO.getContact());
                 entrepreneur.get().setFullName(requestEntrepreneurDTO.getFullName());
                 entrepreneur.get().setSpecialty(requestEntrepreneurDTO.getSpecialty());
                 entrepreneur.get().setCities(city);

                 entrepreneurRepository.save(entrepreneur.get());

                 RequestEntrepreneurDTO responseDTO = new RequestEntrepreneurDTO();

                 responseDTO.setId(entrepreneur.get().getId());
                 responseDTO.setUsername(entrepreneur.get().getUsername());
                 responseDTO.setPassword(entrepreneur.get().getPassword());
                 responseDTO.setEmail(entrepreneur.get().getEmail());
                 responseDTO.setLocked(entrepreneur.get().getLocked());
                 responseDTO.setDisabled(entrepreneur.get().getDisabled());
                 responseDTO.setExperience(entrepreneur.get().getExperience());
                 responseDTO.setContact(entrepreneur.get().getContact());
                 responseDTO.setFullName(entrepreneur.get().getFullName());
                 responseDTO.setSpecialty(entrepreneur.get().getSpecialty());
                 responseDTO.setCityId(city.getIdCity());

                 return responseDTO;


             }else {
                 throw new RuntimeException("Not Found");
             }

    }

    @Override
    public void deleteEntrepreneurById(Long id) {

        Optional<RequestEntrepreneurDTO> optionalEntrepreneur = findByIdEntrepreneur(id);
        if (optionalEntrepreneur.isPresent()){
            this.entrepreneurRepository.deleteById(id);
        }else {
            throw new RuntimeException("No Found");
        }

    }


}
