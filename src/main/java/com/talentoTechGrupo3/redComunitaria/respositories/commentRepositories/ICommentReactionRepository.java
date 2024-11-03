package com.talentoTechGrupo3.redComunitaria.respositories.commentRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.commentEntities.CommentReaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentReactionRepository extends CrudRepository<CommentReaction,Long> {
    List<CommentReaction> findByUserId(Long userId);
}
