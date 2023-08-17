package com.mydemo.demoproject.login;

import com.mydemo.demoproject.Entity.CategoryInfo;
import com.mydemo.demoproject.service.admin.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
    public class LoginController {



    @GetMapping("/login")
    public String loginPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "user/login";
        }

        return "redirect:/home";
    }


}