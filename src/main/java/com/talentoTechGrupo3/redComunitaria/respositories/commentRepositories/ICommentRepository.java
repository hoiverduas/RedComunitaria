package com.talentoTechGrupo3.redComunitaria.respositories.commentRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.commentEntities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepository extends CrudRepository<Comment,Long> {


}
