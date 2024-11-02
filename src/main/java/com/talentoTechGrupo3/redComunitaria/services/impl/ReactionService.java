package com.talentoTechGrupo3.redComunitaria.services.impl;


import com.talentoTechGrupo3.redComunitaria.dto.ReactionCommentDTO;
import com.talentoTechGrupo3.redComunitaria.dto.ReactionPublicationDTO;
import com.talentoTechGrupo3.redComunitaria.entities.*;
import com.talentoTechGrupo3.redComunitaria.respositories.ICommentRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.IPublicationRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.IReactionRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.services.IReactionService;
import org.springframework.stereotype.Service;

@Service
public class ReactionService implements IReactionService {

    private final IReactionRepository reactionRepository;

    private final IUserRepository userRepository;

    private final IPublicationRepository publicationRepository;

    private final ICommentRepository commentRepository;

    public ReactionService(IReactionRepository reactionRepository, IUserRepository userRepository, IPublicationRepository publicationRepository, ICommentRepository commentRepository) {
        this.reactionRepository = reactionRepository;
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public Reaction createReactionPublication(ReactionPublicationDTO reactionPublicationDTO) {


        Long userId = reactionPublicationDTO.getUserId();
        User user = userRepository
                .findById(userId)
                .orElseThrow(()->new RuntimeException("Not Found"));

        Long publicationId = reactionPublicationDTO.getPublicationId();
        Publication publication = publicationRepository
                .findById(publicationId)
                .orElseThrow(()-> new RuntimeException("Not Found"));

        Reaction reaction = new Reaction();

        reaction.setUser(user);
        reaction.setPublication(publication);
        reaction.setReactionType(reactionPublicationDTO.getReactionType());

        return this.reactionRepository.save(reaction);
    }

    @Override
    public Reaction createReactionComment(ReactionCommentDTO reactionCommentDTO) {

          Long userId = reactionCommentDTO.getUserId();
          User user = userRepository
                  .findById(userId)
                  .orElseThrow(()->new RuntimeException("Not Found"));

          Long commentId = reactionCommentDTO.getCommentId();
          Comment comment = commentRepository
                  .findById(commentId).orElseThrow(()->new RuntimeException("Not Found"));

          Reaction reaction = new Reaction();

          reaction.setReactionType(reactionCommentDTO.getReactionType());
          reaction.setComment(comment);
          reaction.setUser(user);

        return this.reactionRepository.save(reaction);
    }
}
