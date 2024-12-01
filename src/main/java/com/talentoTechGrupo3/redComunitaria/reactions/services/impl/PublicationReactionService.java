package com.talentoTechGrupo3.redComunitaria.reactions.services.impl;


import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IPublicationRepository;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction.RequestPublicationReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoPublicatioReaction.ResponsePublicationReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.PublicationReaction;
import com.talentoTechGrupo3.redComunitaria.reactions.repositories.IPublicationReactionRepository;
import com.talentoTechGrupo3.redComunitaria.reactions.services.IPublicationReactionService;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class PublicationReactionService implements IPublicationReactionService {

    private final IPublicationReactionRepository publicationReactionRepository;
    private final IUserRepository userRepository;
    private final IPublicationRepository publicationRepository;
    private final ModelMapper modelMapper;

    public PublicationReactionService(IPublicationReactionRepository publicationReactionRepository, IUserRepository userRepository, IPublicationRepository publicationRepository, ModelMapper modelMapper) {
        this.publicationReactionRepository = publicationReactionRepository;
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponsePublicationReactionDTO createReactionPublication(RequestPublicationReactionDTO requestPublicationReactionDTO) {


        Long userId = requestPublicationReactionDTO.getUserId();
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        Long publicationId = requestPublicationReactionDTO.getPublicationId();
        Publication publication = publicationRepository
                .findById(publicationId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        PublicationReaction publicationReaction = mapToEntity(requestPublicationReactionDTO);
        publicationReaction.setId(null);
        publicationReaction.setUser(user);
        publicationReaction.setPublication(publication);

        publicationReactionRepository.save(publicationReaction);

        ResponsePublicationReactionDTO reactionDTO = mapToDto(publicationReaction);
        reactionDTO.setPublicationId(user.getId());
        reactionDTO.setPublicationId(publication.getId());

        return reactionDTO;

    }

    private ResponsePublicationReactionDTO mapToDto(PublicationReaction publicationReaction){
        return this.modelMapper
                .map(publicationReaction,ResponsePublicationReactionDTO.class);
    }

    private PublicationReaction mapToEntity(RequestPublicationReactionDTO requestPublicationReactionDTO){
        return this.modelMapper
                .map(requestPublicationReactionDTO,PublicationReaction.class);
    }
}
