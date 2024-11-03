package com.talentoTechGrupo3.redComunitaria.respositories;

import com.talentoTechGrupo3.redComunitaria.entities.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepository extends CrudRepository<Comment,Long> {


}
