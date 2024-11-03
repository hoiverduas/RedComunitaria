package com.talentoTechGrupo3.redComunitaria.Users.repositories;

import com.talentoTechGrupo3.redComunitaria.Users.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends CrudRepository<Admin,Long> {
}
