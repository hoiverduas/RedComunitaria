package com.talentoTechGrupo3.redComunitaria.reactions.services.impl;

import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.comments.repository.ICommentRepository;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction.RequestCommentReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.dto.dtoCommetReaction.ResponseCommentReactionDTO;
import com.talentoTechGrupo3.redComunitaria.reactions.entities.CommentReaction;
import com.talentoTechGrupo3.redComunitaria.reactions.repositories.ICommentReactionRepository;
import com.talentoTechGrupo3.redComunitaria.reactions.services.ICommentReactionService;
import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import com.talentoTechGrupo3.redComunitaria.users.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentReactionService implements ICommentReactionService {

    private final ICommentReactionRepository commentReactionRepository;
    private final ICommentRepository commentRepository;
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    public CommentReactionService(ICommentReactionRepository commentReactionRepository, ICommentRepository commentRepository, IUserRepository userRepository, ModelMapper modelMapper) {
        this.commentReactionRepository = commentReactionRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseCommentReactionDTO createReactionComment(RequestCommentReactionDTO requestCommentReactionDTO) {

        Long userId = requestCommentReactionDTO.getUserId();
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        Long commentId = requestCommentReactionDTO.getCommentId();
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new RuntimeException("Not Found"));

        CommentReaction commentReaction = mapEntity(requestCommentReactionDTO);
        commentReaction.setId(null);
        commentReaction.setComment(comment);
        commentReaction.setUser(user);

        commentReactionRepository.save(commentReaction);

        ResponseCommentReactionDTO reactionDTO = mapToDto(commentReaction);
        reactionDTO.setCommentId(comment.getId());
        reactionDTO.setUserId(user.getId());

        return reactionDTO;
    }

    private ResponseCommentReactionDTO mapToDto(CommentReaction commentReaction){
        return this.modelMapper.map(modelMapper,ResponseCommentReactionDTO.class);
    }
    private CommentReaction mapEntity(RequestCommentReactionDTO requestCommentReactionDTO){
        return this.modelMapper.map(requestCommentReactionDTO,CommentReaction.class);
    }

}
