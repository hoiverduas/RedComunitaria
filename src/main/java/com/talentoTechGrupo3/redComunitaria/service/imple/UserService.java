package com.talentoTechGrupo3.redComunitaria.service.imple;

import com.talentoTechGrupo3.redComunitaria.entity.User;
import com.talentoTechGrupo3.redComunitaria.respository.IUserRepository;
import com.talentoTechGrupo3.redComunitaria.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository
                .findById(id)
                .or(()->{throw new RuntimeException("Not found");
                });
    }

    @Override
    public User updateUser(User user) {

        Optional<User>optionalUser=findById(user.getId());

        if (optionalUser.isPresent()){

            User userExist = optionalUser.get();

            userExist.setUserName(user.getUserName());
            userExist.setEmail(user.getEmail());
            userExist.setFullName(user.getFullName());
            userExist.setPassword(user.getPassword());
            userExist.setRoles(user.getRoles());
            userExist.setPhoneNumber(user.getPhoneNumber());

            return this.userRepository.save(userExist);

        }else {
            throw new RuntimeException("User not found");
        }

    }

    @Override
    public void deleteById(Long id) {

          Optional<User>userOptional=findById(id);
          if (userOptional.isPresent()){
              this.userRepository.deleteById(id);
          }else {
              throw new RuntimeException("User not found");
          }
    }
}
