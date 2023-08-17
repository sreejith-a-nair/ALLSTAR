package com.mydemo.demoproject.controller.admin;

import com.mydemo.demoproject.Entity.UserEntity;
import com.mydemo.demoproject.service.admin.user.AdminService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    AdminService adminService;

//    @Autowired
//    PasswordEncoder passwordEncoder;

      /*home */
    @GetMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminHome(Model model){
        System.out.println("search key");
        List<UserEntity> users = adminService.findAll();
        System.out.println("search list" + users);
        model.addAttribute("users", users);
        return "admin/users";
    }



    /*search user*/
    @GetMapping(value = "/search",params = "keyword")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String searchUsers(Model model, @Param("keyword") String keyword){
        try{
        List<UserEntity> users;
        if(keyword != null && !keyword.isEmpty()){
            users = adminService.searchUsers(keyword);
        }
        else{
            users = adminService.loadAllUsers();

//            System.out.println("ADMIN SEARCH"+users);
        }
//        System.out.println("ADMIN SEARCH"+users);


        model.addAttribute("users",users);

        return "admin/users";

    }catch (Exception e){

            e.printStackTrace();

            model.addAttribute("errorMessage", "An error occurred while processing your request.");
            return "error";
        }
    }


   /*   block  user   */
    @GetMapping("/block/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
     public String blockUser(@PathVariable Long id)
     {
             adminService.blockUser(id);
             return "redirect:/admin/home";
     }


     /*Un-block user*/
    @GetMapping("/unblock/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String unBlockUser(@PathVariable Long id)
    {
        adminService.unblockUser(id);
        return  "redirect:/admin/home";
    }

/*    logout*/
    @GetMapping("/logout")
    public String handleLogoutRequest(HttpServletRequest request) {

        request.getSession().invalidate();
        return "redirect:/login?logout";
    }

    @GetMapping("/dashboard")
    public  String getDashboard()
    {
        return "admin/dashboard";
    }



}
