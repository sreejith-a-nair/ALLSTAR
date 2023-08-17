//package com.mydemo.demoproject.service.admin.cartegoryImp;
//
//import com.mydemo.demoproject.Entity.CategoryInfo;
//import com.mydemo.demoproject.Repository.CategoryRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class CategoryUserImp implements UserDetailsService{
//
//    private final CategoryRepo categoryRepo;
//    private final UserDetailsService userDetailsService;
//
//    public CategoryUserImp(CategoryRepo categoryRepo, UserDetailsService userDetailsService) {
//        this.categoryRepo = categoryRepo;
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String category) throws UsernameNotFoundException {
//        Optional<CategoryInfo> CategoryOptional   =  categoryRepo .findBycategoryname(category);
//        CategoryInfo categoryInfo = CategoryOptional
//                .orElseThrow(()-> new UsernameNotFoundException("Category name not found "+category));
//        String categoryName = categoryInfo.getCategoryname();
//        return userDetailsService
//    }
//}
