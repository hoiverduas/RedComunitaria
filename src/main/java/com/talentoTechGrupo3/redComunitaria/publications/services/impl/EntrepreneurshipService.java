package com.talentoTechGrupo3.redComunitaria.publications.services.impl;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.RequestEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.dto.dtoEntrepreneurship.ResponseEntrepreneurshipDTO;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Entrepreneurship;
import com.talentoTechGrupo3.redComunitaria.users.dto.dtoAdmin.ResponseAdminDTO;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IEntrepreneurshipRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.publications.services.IEntrepreneurshipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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
        entrepreneurship.setImage(requestEntrepreneurshipDTO.getImage());

        entrepreneurshipRepository.save(entrepreneurship);

        ResponseEntrepreneurshipDTO responseDTO = mapToDto(entrepreneurship);
        responseDTO.setUserId(userId);
        responseDTO.setStartDate(entrepreneurship.getStartDate());
        responseDTO.setImage(entrepreneurship.getImage());

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

    @Override
    public List<ResponseEntrepreneurshipDTO> findAllEntrepreneurship() {

       Entrepreneurship entrepreneurship = new Entrepreneurship();


        List<Entrepreneurship> entrepreneurships = (List<Entrepreneurship>) entrepreneurshipRepository.findAll();
        ResponseEntrepreneurshipDTO responseDto = new ResponseEntrepreneurshipDTO();
        return entrepreneurships.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ResponseEntrepreneurshipDTO mapToDto(Entrepreneurship entrepreneurship) {
        ResponseEntrepreneurshipDTO dto = new ResponseEntrepreneurshipDTO();
        dto.setId(entrepreneurship.getId());
        dto.setNameCompany(entrepreneurship.getNameCompany());
        dto.setContent(entrepreneurship.getContent());
        dto.setStartDate(entrepreneurship.getStartDate());
        dto.setTypeSector(entrepreneurship.getTypeSector());
        dto.setReceivedInvestment(entrepreneurship.getReceivedInvestment());
        dto.setUserId(entrepreneurship.getUsers().getId());
        dto.setImage(entrepreneurship.getImage());


        return dto;
    }

    private Entrepreneurship mapToEntity(RequestEntrepreneurshipDTO requestEntrepreneurshipDTO) {
        Entrepreneurship entrepreneurship = new Entrepreneurship();

        entrepreneurship.setImage(requestEntrepreneurshipDTO.getImage());
        entrepreneurship.setContent(requestEntrepreneurshipDTO.getContent());
        entrepreneurship.setReceivedInvestment(requestEntrepreneurshipDTO.getReceivedInvestment());
        entrepreneurship.setTypeSector(requestEntrepreneurshipDTO.getTypeSector());
        entrepreneurship.setNameCompany(requestEntrepreneurshipDTO.getNameCompany());


        return entrepreneurship;
    }


}
