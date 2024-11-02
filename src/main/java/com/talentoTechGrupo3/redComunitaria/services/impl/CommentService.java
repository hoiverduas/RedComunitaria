package com.talentoTechGrupo3.redComunitaria.services.impl;

import com.talentoTechGrupo3.redComunitaria.dto.CommentDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Comment;
import com.talentoTechGrupo3.redComunitaria.entities.Publication;
import com.talentoTechGrupo3.redComunitaria.entities.User;
import com.talentoTechGrupo3.redComunitaria.respositories.IAdminRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.ICommentRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.IPublicationRepository;
import com.talentoTechGrupo3.redComunitaria.respositories.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.services.ICommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CommentService implements ICommentService {

    private final ICommentRepository commentRepository;
    private final IUserRepository userRepository;
    private final IPublicationRepository publicationRepository;
    private final IAdminRepository adminRepository;

    public CommentService(ICommentRepository commentRepository, IUserRepository userRepository, IPublicationRepository publicationRepository, IAdminRepository adminRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
        this.adminRepository = adminRepository;
    }


    @Override
    public Comment createEntrepreneurComment(CommentDTO commentDTO) {

        Long userId = commentDTO.getUserId();
        User user = userRepository
                .findById(userId)
                .orElseThrow(()-> new RuntimeException("Not Found"));

        Long publicationId = commentDTO.getPublicationId();
        Publication publication = publicationRepository
                .findById(publicationId)
                .orElseThrow(()-> new RuntimeException("Not Found"));


        Comment comment = new Comment();
        comment.setContent(commentDTO.getContent());
        comment.setUsers(user);
        comment.setPublication(publication);
        comment.setCreationDate(LocalDateTime.now());


        return this.commentRepository.save(comment);
    }
}

