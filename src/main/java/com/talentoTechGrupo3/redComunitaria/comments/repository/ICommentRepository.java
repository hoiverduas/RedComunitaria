package com.talentoTechGrupo3.redComunitaria.comments.repository;

import com.talentoTechGrupo3.redComunitaria.comments.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepository extends CrudRepository<Comment,Long> {


}
