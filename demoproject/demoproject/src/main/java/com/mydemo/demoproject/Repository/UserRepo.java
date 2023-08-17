package com.mydemo.demoproject.Repository;

import com.mydemo.demoproject.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {


    List<UserEntity> findByUsernameNot(String username);


    Optional<UserEntity> findByusername(String username);

    Optional<UserEntity>findByemail(String email);

//    Optional<UserEntity>findBycontact(Long contact);
//
//    Optional<UserEntity>findBypassword(String password );



}
