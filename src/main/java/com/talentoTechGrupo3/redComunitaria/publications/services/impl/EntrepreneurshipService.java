package com.talentoTechGrupo3.redComunitaria.publications.services.impl;
import com.talentoTechGrupo3.redComunitaria.publications.dto.CreateEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.Users.entities.User;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IEntrepreneurshipRepository;
import com.talentoTechGrupo3.redComunitaria.Users.repositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.publications.services.IEntrepreneurshipService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class EntrepreneurshipService implements IEntrepreneurshipService {

    private final IEntrepreneurshipRepository entrepreneurshipRepository;
    private final IUserRepository userRepository;

    public EntrepreneurshipService(IEntrepreneurshipRepository entrepreneurshipRepository, IUserRepository userRepository) {
        this.entrepreneurshipRepository = entrepreneurshipRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Entrepreneurship createEntrepreneurship(CreateEntrepreneurshipDTO createEntrepreneurshipDTO) {

        Long userId = createEntrepreneurshipDTO.getUserId();
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));


        Entrepreneurship entrepreneurship = new Entrepreneurship();

        entrepreneurship.setUsers(user);
        entrepreneurship.setNameCompany(createEntrepreneurshipDTO.getNameCompany());
        entrepreneurship.setReceivedInvestment(createEntrepreneurshipDTO.getReceivedInvestment());
        entrepreneurship.setTypeSector(createEntrepreneurshipDTO.getTypeSector());
        entrepreneurship.setContent(createEntrepreneurshipDTO.getContent());

        entrepreneurship.setStartDate(LocalDateTime.now().now());

        return entrepreneurshipRepository.save(entrepreneurship);

    }

}
