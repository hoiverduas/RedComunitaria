package com.talentoTechGrupo3.redComunitaria.reactions.repositories;

import com.talentoTechGrupo3.redComunitaria.reactions.entities.CommentReaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentReactionRepository extends CrudRepository<CommentReaction,Long> {
    List<CommentReaction> findByUserId(Long userId);
}
