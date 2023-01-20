package com.garofalo.sportyshoes_ecommerce.service;

import com.garofalo.sportyshoes_ecommerce.entity.UserEntity;
import com.garofalo.sportyshoes_ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //injecting productrepo into the service
    UserRepository userRepository;

    //CUSTOM METHODS - all available thanks to field injection
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll(); //gets all the data from the repo
    }

    public UserEntity getUser(long id){
        return userRepository.findById(id).get();
    }

    public void addUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }


    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

}
