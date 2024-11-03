package com.talentoTechGrupo3.redComunitaria.services.impl;


import com.talentoTechGrupo3.redComunitaria.entities.*;
import com.talentoTechGrupo3.redComunitaria.respositories.*;
import com.talentoTechGrupo3.redComunitaria.services.IReactionService;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReactionService implements IReactionService {

    private final IReactionRepository reactionRepository;

    private final IUserRepository userRepository;

    private final IPublicationRepository publicationRepository;

    private final ICommentRepository commentRepository;

    private final IPublicationReactionRepository publicationReactionRepository;

    private final ICommentReactionRepository commentReactionRepository;

    public ReactionService(IReactionRepository reactionRepository,
                           IUserRepository userRepository,
                           IPublicationRepository publicationRepository,
                           ICommentRepository commentRepository,
                           IPublicationReactionRepository publicationReactionRepository,
                           ICommentReactionRepository commentReactionRepository) {

        this.reactionRepository = reactionRepository;
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.commentRepository = commentRepository;
        this.publicationReactionRepository = publicationReactionRepository;
        this.commentReactionRepository = commentReactionRepository;
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