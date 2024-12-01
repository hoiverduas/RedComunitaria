package com.talentoTechGrupo3.redComunitaria.comments.services;

import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;

import java.util.List;

public interface ICommentService {

    Comment createEntrepreneurComment(RequestCommentDTO commentDTO);
    List<Comment> findAllComment();
    Comment findByComment(Long id);
    String  deleteCommentById(Long id);
    //Comment deleteComment(Long idComment,Long idUser,Long idPublication);
}
