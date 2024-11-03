package com.talentoTechGrupo3.redComunitaria.respositories.userRepositories;

import com.talentoTechGrupo3.redComunitaria.entities.userEntities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends CrudRepository<Admin,Long> {
}
