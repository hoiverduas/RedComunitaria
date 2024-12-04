package com.talentoTechGrupo3.redComunitaria.publications.services.impl;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.RequestEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IEntrepreneurshipRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.publications.services.IEntrepreneurshipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class EntrepreneurshipService implements IEntrepreneurshipService {

    private final IEntrepreneurshipRepository entrepreneurshipRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    public EntrepreneurshipService(IEntrepreneurshipRepository entrepreneurshipRepository, IUserRepository userRepository, ModelMapper modelMapper) {
        this.entrepreneurshipRepository = entrepreneurshipRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntrepreneurshipDTO createEntrepreneurship(RequestEntrepreneurshipDTO requestEntrepreneurshipDTO) {

        Long userId = requestEntrepreneurshipDTO.getUserId();
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Entrepreneurship entrepreneurship = mapToEntity(requestEntrepreneurshipDTO);
        entrepreneurship.setId(null);
        entrepreneurship.setUsers(user);
        entrepreneurship.setStartDate(LocalDateTime.now());

        entrepreneurshipRepository.save(entrepreneurship);

        ResponseEntrepreneurshipDTO responseDTO = mapToDto(entrepreneurship);
        responseDTO.setUserId(userId);
        responseDTO.setStartDate(entrepreneurship.getStartDate());


        return responseDTO;


    }

    @Override
    public String deletePublication(Long id) {
       findPublicationById(id);
        entrepreneurshipRepository.deleteById(id);
        return "La publicacion con id : "+ id + " fue eliminanda exitosamente";
    }

    @Override
    public ResponseEntrepreneurshipDTO findPublicationById(Long id) {
               Entrepreneurship entrepreneurship = entrepreneurshipRepository
                       .findById(id)
                       .orElseThrow(()->new RuntimeException("not Found"));
        return mapToDto(entrepreneurship);
    }

    private ResponseEntrepreneurshipDTO mapToDto(Entrepreneurship entrepreneurship){
        return this.modelMapper
                .map(entrepreneurship,ResponseEntrepreneurshipDTO.class);
    }

    private Entrepreneurship mapToEntity(RequestEntrepreneurshipDTO requestEntrepreneurshipDTO){
        return this.modelMapper
                .map(requestEntrepreneurshipDTO,Entrepreneurship.class);
    }

}
