package com.talentoTechGrupo3.redComunitaria.comments.repository;

import com.talentoTechGrupo3.redComunitaria.comments.entities.CommentReaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentReactionRepository extends CrudRepository<CommentReaction,Long> {
    List<CommentReaction> findByUserId(Long userId);
}
