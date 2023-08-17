package com.mydemo.demoproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="Category_Info")
public class CategoryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Category_Name")
    private  String categoryname;
    @Column(name = "Category_Description")
    private String description;
//    @Column(name = "Role")
//    private String role;



//   @OneToMany(mappedBy = "category")

}
