package com.talentoTechGrupo3.redComunitaria.services.impl;

import com.talentoTechGrupo3.redComunitaria.entities.userEntities.Entrepreneur;
import com.talentoTechGrupo3.redComunitaria.respositories.userRepositories.IEntrepreneurRepository;
import com.talentoTechGrupo3.redComunitaria.services.IEntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EntrepreneurService implements IEntrepreneurService {

    private final IEntrepreneurRepository entrepreneurRepository;


    @Autowired
    public EntrepreneurService(IEntrepreneurRepository entrepreneurRepository) {
        this.entrepreneurRepository = entrepreneurRepository;

    }


    @Override
    public Entrepreneur createEntrepreneur(Entrepreneur entrepreneur) {
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
    public Entrepreneur updateEntrepreneur(Entrepreneur entrepreneur) {

             Optional<Entrepreneur>optionalEntrepreneur =findByIdEntrepreneur(entrepreneur.getId());

             if (optionalEntrepreneur.isPresent()){

                 Entrepreneur existEntrepreneur = optionalEntrepreneur.get();

                 existEntrepreneur.setPassword(entrepreneur.getPassword());
                 existEntrepreneur.setUsername(entrepreneur.getUsername());
                 existEntrepreneur.setFullName(entrepreneur.getFullName());
                 existEntrepreneur.setExperience(entrepreneur.getExperience());
                 existEntrepreneur.setSpecialty(entrepreneur.getSpecialty());
                 existEntrepreneur.setDisabled(entrepreneur.getDisabled());
                 existEntrepreneur.setEmail(entrepreneur.getEmail());
                 existEntrepreneur.setLocked(entrepreneur.getLocked());
                 existEntrepreneur.setContact(entrepreneur.getContact());

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
