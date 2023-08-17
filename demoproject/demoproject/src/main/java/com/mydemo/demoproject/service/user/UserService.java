package com.mydemo.demoproject.service.user;

import com.mydemo.demoproject.Entity.UserEntity;
import com.mydemo.demoproject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;
@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public  String  addUser(UserEntity userEntity , Model model)
    {
        Optional<UserEntity> varifyUsername  =userRepo.findByusername(userEntity.getUsername());
        Optional<UserEntity> varifyEmail= userRepo.findByemail(userEntity.getEmail());
//        Optional <UserEntity> varifyContact  =userRepo.findBycontact(userEntity.getContact());
//        Optional<UserEntity> varifyPassword = userRepo.findBypassword(userEntity.getPassword());

        if (varifyUsername.isPresent())
        {
            model.addAttribute("errorMessage","Username already exists");
            return "signup";
        }
        else if (varifyEmail.isPresent())
        {
            model.addAttribute("errorMessage","E-mail already exists");
            return "signup";
        }
//        else if (varifyPassword.isPresent())
//        {
//            model.addAttribute("errorMessage","Password already exists");
//            return "signup";
//        }
//        else if (varifyContact.isPresent())
//        {
//            model.addAttribute("errorMessage","Contact already exists");
//            return "signup";
//        }
        else {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userRepo.save(userEntity);
            return  "login";
        }

    }

    public List<UserEntity> findAll() {
        return userRepo.findByUsernameNot("admin");
    }

    public  Optional<UserEntity>getUserdata(String username)
    {
       return  userRepo.findByusername(username);
    }



}

