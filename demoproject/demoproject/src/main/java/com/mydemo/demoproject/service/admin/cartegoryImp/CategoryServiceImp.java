package com.mydemo.demoproject.service.admin.cartegoryImp;

import com.mydemo.demoproject.Entity.CategoryInfo;
import com.mydemo.demoproject.Entity.UserEntity;
import com.mydemo.demoproject.Repository.CategoryRepo;
import com.mydemo.demoproject.service.admin.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoryServiceImp implements CategoryService {


    @Autowired
    CategoryRepo categoryRepo;



    @Override
    public Optional<CategoryInfo> getCategory(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public List<CategoryInfo> findAll() {
        return categoryRepo.findAll();
    }


    /*AddCategory Service */

    @Override
    public String addCategory(CategoryInfo categoryInfo, Model model) {

        Optional<CategoryInfo> existingUser = categoryRepo.findBycategoryname(categoryInfo.getCategoryname());
        if (existingUser.isPresent()) {
            model.addAttribute("errorMessage", "category already exists");
            return "admin/add-category";
        } else {
            categoryRepo.save(categoryInfo);
            return "admin/dashboard";

        }

    }

    /*Search*/

    @Override
    public List<CategoryInfo> searchCategory(String keyword) {
        return categoryRepo.findByCategoryKeyword(keyword);
    }

    @Override
    public List<CategoryInfo> loadAllCategory() {
        return categoryRepo.findAll();
    }


    /*delete method*/
    @Override
    public void delete(Long id) {
     categoryRepo.deleteById(id);
    }


    @Override
    public void updateCategory(CategoryInfo categoryInfo){

    }

    /*category save */

    @Override
    public CategoryInfo save(CategoryInfo categoryInfo) {
        return categoryRepo.save(categoryInfo);
    }
}