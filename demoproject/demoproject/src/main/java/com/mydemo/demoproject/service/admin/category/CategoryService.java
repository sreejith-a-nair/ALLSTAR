package com.mydemo.demoproject.service.admin.category;

import com.mydemo.demoproject.Entity.CategoryInfo;
import com.mydemo.demoproject.Entity.UserEntity;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    Optional<CategoryInfo> getCategory(Long id);

    List<CategoryInfo> findAll();


/*add-category repo*/
    String addCategory(CategoryInfo categoryInfo, Model model);


/* Search method*/
    List<CategoryInfo> searchCategory(String keyword);


     List<CategoryInfo> loadAllCategory() ;



    void delete(Long id);

    void updateCategory(CategoryInfo categoryInfo);

   CategoryInfo save (CategoryInfo categoryInfo);


}
