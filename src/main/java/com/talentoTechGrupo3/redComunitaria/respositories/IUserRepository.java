package com.talentoTechGrupo3.redComunitaria.respositories;

import com.talentoTechGrupo3.redComunitaria.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
}
