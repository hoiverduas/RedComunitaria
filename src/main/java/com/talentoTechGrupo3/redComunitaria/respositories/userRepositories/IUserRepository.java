package com.talentoTechGrupo3.redComunitaria.respositories.userRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.userEntities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
}
