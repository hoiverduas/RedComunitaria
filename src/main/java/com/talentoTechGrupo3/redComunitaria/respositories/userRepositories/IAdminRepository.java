package com.talentoTechGrupo3.redComunitaria.respositories;

import com.talentoTechGrupo3.redComunitaria.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends CrudRepository<Admin,Long> {
}
