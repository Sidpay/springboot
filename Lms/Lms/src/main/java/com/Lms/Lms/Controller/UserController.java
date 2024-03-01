package com.Lms.Lms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Lms.Lms.Entity.Book;
import com.Lms.Lms.Entity.User;
import com.Lms.Lms.Service.UserService;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
   
    @GetMapping("/use")
    public String addBooks() {
    	return "AddUser";
    }

    @GetMapping("/user")
   	public ModelAndView getApplicables() {
   		//TODO: process POST request
   		List<User>list=userService.findAll();
//   		ModelAndView mv=new ModelAndView();
//   		mv.setViewName("Application");
//   		mv.addObject("Jobs",list);
   		return new ModelAndView("allusers","user",list);
   	}
    
    

   
    @PostMapping("/sa")
   	public String creatUser(@ModelAttribute User user) {
   		//TODO: process POST request
   		userService.save(user);
   		return "redirect:/user";
       }
}