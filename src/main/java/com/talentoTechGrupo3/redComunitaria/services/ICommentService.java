package com.talentoTechGrupo3.redComunitaria.services;

import com.talentoTechGrupo3.redComunitaria.dto.CommentDTO;
import com.talentoTechGrupo3.redComunitaria.entities.Comment;

public interface ICommentService {

    Comment createEntrepreneurComment(CommentDTO commentDTO);
}
