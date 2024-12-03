package com.talentoTechGrupo3.redComunitaria.comments.repository;

import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends CrudRepository<Comment,Long> {

}
