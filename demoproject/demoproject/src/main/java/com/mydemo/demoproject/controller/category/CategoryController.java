package com.mydemo.demoproject.controller.category;

import com.mydemo.demoproject.Entity.CategoryInfo;

import com.mydemo.demoproject.service.admin.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /* 1 Show home*/
    @GetMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String showAll(Model model) {
        List<CategoryInfo> categoryInfo = categoryService.findAll();
        model.addAttribute("categoryInfo", categoryInfo);
        return "admin/category";
    }



    /* 2 add Category*/

    @GetMapping("/addcategory")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addCategory() {
        return "admin/add-category";
    }


    /*3 save*/
    @PostMapping("/save")
    public String save(@ModelAttribute CategoryInfo categoryInfo) {

        categoryService.save(categoryInfo);
        return "redirect:/category/home";
    }

    /*  edit category*/

    @GetMapping("/edits")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String editCategory() {
        return "admin/edit-category";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String editCategory(@PathVariable Long id, Model model) {
        System.out.println("editCategory method..............." + id);
        Optional<CategoryInfo> categoryopptional = categoryService.getCategory(id);
        if (categoryopptional.isPresent()) {
            System.out.println("is present");
            CategoryInfo categoryInfo = categoryopptional.get();

            model.addAttribute("id", id);
            model.addAttribute("categoryname", categoryInfo.getCategoryname());
            model.addAttribute("description", categoryInfo.getDescription());
            return "admin/edit-category";
        } else {
            return String.valueOf(model.addAttribute("error message", "Invalid valid data"));
        }
    }

    /*delete category*/
    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        System.out.println("delete category>>>>>>>>>>>>>>");
        categoryService.delete(id);
        return "redirect:/category/home";
    }

//    @GetMapping("/delete-record")
//    public String delete(@PathVariable Long id)
//    {
//        System.out.println("helpppppppppppppppppppppppp");
//        return "redirect:/category/delete/{id}";
//    }


    /*search category*/

    @GetMapping(value = "/search", params = "keyword")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String searchCategory(Model model, @RequestParam("keyword") String keyword) {
        System.out.println("search>begin.....>>>>>>>");

        try {

            List<CategoryInfo> categoryList;

            if (keyword != null && !keyword.isEmpty()) {
                categoryList = categoryService.searchCategory(keyword);

                System.out.println("search>>>>if" + categoryList);

            } else {
                System.out.println("search--else------->>>");
                
                categoryList = categoryService.loadAllCategory();
            }

            model.addAttribute("categoryInfo", categoryList);

            return "admin/category";

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute("errorMessage", "An error occurred while processing your request.");
            return "error";
        }

    }

    /*logout*/
    @GetMapping("/logout")
    public String handleLogoutRequest(HttpServletRequest request) {

        request.getSession().invalidate();
        return "redirect:/login?logout";
    }



}




























































    /*ADD CATEGORY*/

//    @PostMapping("/addCategory")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String addCategory(@ModelAttribute CategoryInfo categoryInfo, Model model) {
//        categoryInfo.setRole("ROLE_USER");
//        String result = categoryService.addCategory(categoryInfo,model);
//        return result;
//    }
//
//
//
//    /*SHOW ALL CATEGORY LIST*/
//
////   /* @GetMapping("/home")
////
////    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
////    public String showAll(Model model){
////        List<CategoryInfo> users = categoryService.findAll();
////        model.addAttribute("users", users);
////        return "users";
////    }
////*/
//
//
//    /*EDIT CATEGORY*/
//
////    @GetMapping("/edit/{id}")
////    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
////    public String editUser(@PathVariable Long id, Model model){
////        Optional<CategoryInfo> categoryInfo = categoryService. getCategoryDetails(id);
////        model.addAttribute("id",id);
////        model.addAttribute("categoryname",categoryInfo.get().getCategoryname());
////        model.addAttribute("description",categoryInfo.get().getDescription());
////
////        return "edit-details    ";
////    }
//
//
//    /*DELETE CATEGORY*/
//    @DeleteMapping("/delete/{id}")
//    public String deleteUserById(@PathVariable Long id) {
//        categoryService.deleteCategory(id);
//        return "redirect:/admin/home";
//    }
//
//
//    /*SAVE CATEGORY*/
////    @PostMapping("/save")
////    public  String save(@ModelAttribute CategoryInfo categoryInfo){
////        categoryInfo.setRole("ROLE_USER");
////        categoryService.save(categoryInfo);
////        return "redirect:/admin/home";
////    }
//
//
//    /*SEARCH CATEGORY*/
//    @GetMapping("/search")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String search(Model model,@RequestParam String keyword){
//        List<CategoryInfo> category;
//        if(keyword == null){
//            category = categoryService.loadAllUsers();
//        }
//        else{
//            category = categoryService.searchUsers(keyword);
////            System.out.println(users);
//        }
//
//        model.addAttribute("users",category);
//
//        return "dashboard";
//    }
//
//
//    /*PAGES */
//
//    /*DASHBOARD*/
////    @GetMapping("/showdashboard")
////    public  String showDashboard()
////    {
////        return "dashboard";
////    }
////
////    /*CATEGORY*/
////
////    @GetMapping("/showcategory")
////    public String showCategory()
////    {
////        return "category";
////    }
//
//    /*PRODUCT*/
////    @GetMapping("/showproduct")
////    public String showProduct()
////    {
////        return "product";
////    }
////
////}
//}