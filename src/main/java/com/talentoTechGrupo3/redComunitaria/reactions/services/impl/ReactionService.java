package com.talentoTechGrupo3.redComunitaria.reactions.services.impl;


import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.publications.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.CommentReaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.PublicationReaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.Reaction;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.ReactionType;
import com.talentoTechGrupo3.redComunitaria.reactions.services.IReactionService;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.reactions.repositories.ICommentReactionRepository;
import com.talentoTechGrupo3.redComunitaria.comments.repository.ICommentRepository;
import com.talentoTechGrupo3.redComunitaria.reactions.repositories.IPublicationReactionRepository;
import com.talentoTechGrupo3.redComunitaria.publications.repositories.IPublicationRepository;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReactionService implements IReactionService {


    private final IUserRepository userRepository;

    private final IPublicationRepository publicationRepository;

    private final ICommentRepository commentRepository;

    private final IPublicationReactionRepository publicationReactionRepository;

    private final ICommentReactionRepository commentReactionRepository;

    private final ModelMapper modelMapper;

    public ReactionService(
            IUserRepository userRepository,
            IPublicationRepository publicationRepository,
            ICommentRepository commentRepository,
            IPublicationReactionRepository publicationReactionRepository,
            ICommentReactionRepository commentReactionRepository,
            ModelMapper modelMapper) {

        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.publicationReactionRepository = publicationReactionRepository;
        this.commentReactionRepository = commentReactionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Reaction createReactionPublication(Long userId,
                                              Long publicationId,
                                              ReactionType reactionType) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        Publication publication = publicationRepository
                .findById(publicationId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        PublicationReaction publicationReaction = new PublicationReaction();

        publicationReaction.setUser(user);
        publicationReaction.setPublication(publication);
        publicationReaction.setReactionType(reactionType);

        return this.publicationReactionRepository.save(publicationReaction);

    }

    @Override
    public Reaction createReactionComment(Long userId, Long commentId, ReactionType reactionType) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        CommentReaction commentReaction = new CommentReaction();

        commentReaction.setComment(comment);
        commentReaction.setUser(user);
        commentReaction.setReactionType(reactionType);

        return this.commentReactionRepository.save(commentReaction);
    }

    @Override
    public void deleteReaction(Long id) {

        commentReactionRepository.findById(id)
                .ifPresentOrElse(
                        commentReactionRepository::delete,
                        // Si no existe, intenta eliminar una PublicationReaction
                        () -> publicationReactionRepository.findById(id).ifPresent(publicationReactionRepository::delete)
                );
    }

    @Override
    public List<Reaction> findByReactionByUser(Long userId) {
        // Buscar reacciones del usuario en ambos repositorios
        List<CommentReaction> commentReactions = commentReactionRepository.findByUserId(userId);
        List<PublicationReaction> publicationReactions = publicationReactionRepository.findByUserId(userId);
        // Combinar las listas en una sola
        return Stream.concat(commentReactions.stream(), publicationReactions.stream())
                .collect(Collectors.toList());


    }



}