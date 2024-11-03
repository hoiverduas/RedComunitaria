package com.talentoTechGrupo3.redComunitaria.comments.services;

import com.talentoTechGrupo3.redComunitaria.comments.dto.CommentDTO;
import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;

public interface ICommentService {

    Comment createEntrepreneurComment(CommentDTO commentDTO);
}
