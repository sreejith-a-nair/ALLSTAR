package com.mydemo.demoproject.service.admin.user.UserImp;

import com.mydemo.demoproject.Entity.UserEntity;
import com.mydemo.demoproject.Repository.AdminRepo;
import com.mydemo.demoproject.security.SecurityImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AdminServiceImp implements UserDetailsService {
   @Autowired
   private AdminRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user   =   adminRepo.findByusername(username);
        return user.map(SecurityImp::new)
                .orElseThrow(()-> new UsernameNotFoundException("username not found "+username));
    }
}
