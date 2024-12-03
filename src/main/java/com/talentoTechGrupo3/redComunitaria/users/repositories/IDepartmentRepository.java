package com.talentoTechGrupo3.redComunitaria.users.repositories;

import com.talentoTechGrupo3.redComunitaria.users.entities.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends CrudRepository<Department,Long> {

}
