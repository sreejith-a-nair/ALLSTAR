package com.mydemo.demoproject.Repository;

import com.mydemo.demoproject.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AdminRepo extends JpaRepository<UserEntity,Long> {


    List<UserEntity> findByUsernameNot(String username);


    Optional<UserEntity> findByusername(String username);



    @Query(value = "select * from User_data where user_name like %:keyword% or first_name like  %:keyword%", nativeQuery = true)
    List<UserEntity> findByKeyword(@Param("keyword") String keyword);



}
