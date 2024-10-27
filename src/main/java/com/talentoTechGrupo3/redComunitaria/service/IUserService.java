package com.talentoTechGrupo3.redComunitaria.service;

import com.talentoTechGrupo3.redComunitaria.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User createUser(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    User updateUser(User user);
    void deleteById(Long id);

}
