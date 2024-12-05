package com.talentoTechGrupo3.redComunitaria.comments.services;

import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestUpdateCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.dto.ResponseCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;

import java.util.List;

public interface ICommentService {

    ResponseCommentDTO createEntrepreneurComment(RequestCommentDTO commentDTO);
    List<ResponseCommentDTO> findAllComment();
    ResponseCommentDTO findByComment(Long id);
    String  deleteCommentById(Long id);
    ResponseCommentDTO updateComment(RequestUpdateCommentDTO commentDTO);
}
