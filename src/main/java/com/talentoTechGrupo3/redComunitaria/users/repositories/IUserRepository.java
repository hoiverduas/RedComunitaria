package com.talentoTechGrupo3.redComunitaria.users.repositories;

import com.talentoTechGrupo3.redComunitaria.users.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
