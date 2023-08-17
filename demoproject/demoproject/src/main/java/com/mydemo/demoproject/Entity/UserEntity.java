package com.mydemo.demoproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Entity
    @Table(name = "User_data")
    public class UserEntity{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "user_name")
        private String username;
        @Column(name = "first_name")
        private  String firstname;
        @Column(name = "last_name")
        private  String lastname;
        @Column(name = "contact")
        private  Long contact;
        @Column(name = "email")
        private  String email;
        @Column(name = "password")
        private  String password;
        @Column(name = "roles")
        private  String role;

        private  boolean blocked;
    }


