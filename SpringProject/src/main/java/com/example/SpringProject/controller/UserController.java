package com.example.SpringProject.controller;
import com.example.SpringProject.entity.User;
import com.example.SpringProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String homePage() {

        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signupForm";
    }

    @PostMapping("/processRegister")
    public String processRegister(@Valid User user, Errors errors) {
        // validation
        if (null != errors && errors.getErrorCount() > 0 ) {
            return "signupForm";
        } else if(!user.getRetypePassword().equals(user.getPassword())) {
            errors.rejectValue("retypePassword", "Password and Confirm not the same", null, "Password and Confirm not the same!");
            return "signupForm";
        } else{
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepo.save(user);

            return "registerSuccess";
        }
    }




    @GetMapping("admin/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "admin/users";
    }

    // Update form
    @GetMapping("/admin/showUserUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("/admin/userUpdateForm");
        User user = userRepo.findById(userId).get();
        mav.addObject("user", user);

        return mav;
    }
    // Save User
    @PostMapping("/admin/saveUser")
    public String saveUser(@Valid User user, Errors errors) {
        // validation
        if (null != errors && errors.getErrorCount() > 0) {
            return "/admin/userUpdateForm";
        } else {
            userRepo.save(user);
            return "redirect:/admin/users";
        }
    }

    // Delete User
    @GetMapping("admin/deleteUser")
    public String deletePerson(@RequestParam Long userId){
        userRepo.deleteById(userId);
        return "redirect:/admin/users";
    }

}
