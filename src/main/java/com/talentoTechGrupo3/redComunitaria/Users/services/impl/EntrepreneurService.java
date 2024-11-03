package com.talentoTechGrupo3.redComunitaria.Users.services.impl;

import com.talentoTechGrupo3.redComunitaria.Users.dto.RequestEntrepreneurDTO;
import com.talentoTechGrupo3.redComunitaria.Users.entities.City;
import com.talentoTechGrupo3.redComunitaria.Users.entities.Entrepreneur;
import com.talentoTechGrupo3.redComunitaria.Users.repositories.ICityRepository;
import com.talentoTechGrupo3.redComunitaria.Users.repositories.IEntrepreneurRepository;
import com.talentoTechGrupo3.redComunitaria.Users.services.IEntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EntrepreneurService implements IEntrepreneurService {

    private final IEntrepreneurRepository entrepreneurRepository;
    private final ICityRepository cityRepository;


    @Autowired
    public EntrepreneurService(IEntrepreneurRepository entrepreneurRepository, ICityRepository cityRepository) {
        this.entrepreneurRepository = entrepreneurRepository;

        this.cityRepository = cityRepository;
    }


    @Override
    public Entrepreneur createEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO) {

        Long cityId = requestEntrepreneurDTO.getCityId();
        City city = cityRepository
                .findById(cityId)
                .orElseThrow(()->new RuntimeException("Not Found"));

        Entrepreneur entrepreneur = new Entrepreneur();
        entrepreneur.setId(requestEntrepreneurDTO.getId());
        entrepreneur.setUsername(requestEntrepreneurDTO.getUsername());
        entrepreneur.setPassword(requestEntrepreneurDTO.getPassword());
        entrepreneur.setEmail(requestEntrepreneurDTO.getEmail());
        entrepreneur.setLocked(requestEntrepreneurDTO.getLocked());
        entrepreneur.setDisabled(requestEntrepreneurDTO.getDisabled());
        entrepreneur.setExperience(requestEntrepreneurDTO.getExperience());
        entrepreneur.setContact(requestEntrepreneurDTO.getContact());
        entrepreneur.setFullName(requestEntrepreneurDTO.getFullName());
        entrepreneur.setSpecialty(requestEntrepreneurDTO.getSpecialty());
        entrepreneur.setCities(city);
        return this.entrepreneurRepository.save(entrepreneur);
    }

    @Override
    public List<Entrepreneur> findAllEntrepreneur() {
        return (List<Entrepreneur>) this.entrepreneurRepository.findAll();
    }

    @Override
    public Optional<Entrepreneur> findByIdEntrepreneur(Long id) {
        return this.entrepreneurRepository
                .findById(id)
                .or(()->{throw new RuntimeException("Not Found");
                });
    }

    @Override
    public Entrepreneur updateEntrepreneur(RequestEntrepreneurDTO requestEntrepreneurDTO) {

             Optional<Entrepreneur>optionalEntrepreneur =findByIdEntrepreneur(requestEntrepreneurDTO.getId());

             if (optionalEntrepreneur.isPresent()){

                 Entrepreneur existEntrepreneur = optionalEntrepreneur.get();

                 existEntrepreneur.setPassword(requestEntrepreneurDTO.getPassword());
                 existEntrepreneur.setUsername(requestEntrepreneurDTO.getUsername());
                 existEntrepreneur.setFullName(requestEntrepreneurDTO.getFullName());
                 existEntrepreneur.setExperience(requestEntrepreneurDTO.getExperience());
                 existEntrepreneur.setSpecialty(requestEntrepreneurDTO.getSpecialty());
                 existEntrepreneur.setDisabled(requestEntrepreneurDTO.getDisabled());
                 existEntrepreneur.setEmail(requestEntrepreneurDTO.getEmail());
                 existEntrepreneur.setLocked(requestEntrepreneurDTO.getLocked());
                 existEntrepreneur.setContact(requestEntrepreneurDTO.getContact());

                 return this.entrepreneurRepository.save(existEntrepreneur);
             }else {
                 throw new RuntimeException("Not Found");
             }

    }

    @Override
    public void deleteEntrepreneurById(Long id) {

        Optional<Entrepreneur> optionalEntrepreneur = findByIdEntrepreneur(id);
        if (optionalEntrepreneur.isPresent()){
            this.entrepreneurRepository.deleteById(id);
        }else {
            throw new RuntimeException("No Found");
        }

    }


}
