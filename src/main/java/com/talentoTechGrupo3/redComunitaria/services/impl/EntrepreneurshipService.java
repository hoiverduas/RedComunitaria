package com.talentoTechGrupo3.redComunitaria.services.impl;
import com.talentoTechGrupo3.redComunitaria.dto.CreateEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.entities.publicationEntities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.entities.userEntities.User;
import com.talentoTechGrupo3.redComunitaria.respositories.publicationRepositories.IEntrepreneurshipRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.userRepositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.services.IEntrepreneurshipService;
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
