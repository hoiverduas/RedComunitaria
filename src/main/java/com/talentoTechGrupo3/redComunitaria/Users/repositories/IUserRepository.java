package com.talentoTechGrupo3.redComunitaria.Users.repositories;

import com.talentoTechGrupo3.redComunitaria.Users.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User,Long> {
}
