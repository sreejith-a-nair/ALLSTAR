package com.mydemo.demoproject.service.admin.user;

import com.mydemo.demoproject.Entity.UserEntity;
import com.mydemo.demoproject.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity save(UserEntity user) {
        return  adminRepo.save(user);
    }


    public List<UserEntity> loadAllUsers() {
        return  adminRepo.findAll();
    }

    public List<UserEntity> searchUsers(String keyword) {
        return adminRepo.findByKeyword(keyword);
    }

//    public Optional<UserEntity> getUserdetails(Long id){
//
//        return adminRepo.findById(id);
//    }

    public List<UserEntity> findAll() {
        return adminRepo.findByUsernameNot("admin");
    }

    /*  block user*/
    public  void  blockUser(Long userId)
    {
      Optional<UserEntity>  userdata =adminRepo.findById(userId);
       if (userdata.isPresent())
       {
          UserEntity user= userdata.get();
          user.setBlocked(true);
          adminRepo.save(user);
       }
       else {
           throw new EntityNotFoundException("User not found with ID: " + userId);
       }
    }

      /*  unblock user*/
     public  void unblockUser(Long userid)
     {
         Optional<UserEntity> userdata = adminRepo.findById(userid);
         if (userdata.isPresent())
         {
             UserEntity user= userdata.get();
             user.setBlocked(false);
             adminRepo.save(user);
         }
         else {
             throw new EntityNotFoundException("User not found with ID: " + userid);
         }
     }

}



