package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.dto.CommentDTO;
import com.talentoTechGrupo3.redComunitaria.entities.commentEntities.Comment;

public interface ICommentService {

    Comment createEntrepreneurComment(CommentDTO commentDTO);
}
