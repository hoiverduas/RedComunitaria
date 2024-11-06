package com.talentoTechGrupo3.redComunitaria.comments.services;

import com.talentoTechGrupo3.redComunitaria.comments.dto.RequestCommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;

public interface ICommentService {

    Comment createEntrepreneurComment(RequestCommentDTO commentDTO);
}
