package com.talentoTechGrupo3.redComunitaria.respository;

import com.talentoTechGrupo3.redComunitaria.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
}
