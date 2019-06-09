package com.ani.eshopfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.ani.eshopbackend.daoimpl.UserDaoImpl;
import com.ani.eshopbackend.model.User;
@Controller
public class UserController {
	
	 @Autowired
	    UserDaoImpl userdao;
	 
	 // ------------  Register Form --------------------  //
	 
	 
	 
	    @RequestMapping("/register")
	    public ModelAndView registerform()
	    {
	        User user=new User();
	        ModelAndView mv=new ModelAndView("UserRegisterPage");
	        mv.addObject("registerform",user);
	        return mv;
	    }
	@RequestMapping("/receiveform")
	    public ModelAndView receiveregisterform(@ModelAttribute("registerform")User user)
	    {
		  ModelAndView modelAndView=new ModelAndView("UserHome");
	    userdao.addUser(user);
	      return modelAndView;
	    }    

	    //------------    Login Controller ----------------- //
	
	@RequestMapping("/loginpage")
	public ModelAndView gotoLoginform()
	{
	    User user=new User();
	    ModelAndView mv=new ModelAndView("LoginPage");
	    mv.addObject("loginform",user);
	    return mv;
	}
	@RequestMapping("/login")
	public ModelAndView LoginPage(@ModelAttribute("loginform")User user)
	{
	  boolean result=userdao.checkLogin(user);
	 if(result==true)
	 {
		 ModelAndView modelAndView=new ModelAndView("LoginSuccessful");
		 return modelAndView;
	 }else
	 {
		 ModelAndView modelAndView=new ModelAndView("LoginPage");
		 modelAndView.addObject("Wronguser","wrongusername/password");
		 return modelAndView;
		 
	 }
	}
	
	// --------------- Spring security login ----------------  //
	
	
	@RequestMapping("/loginerror")
	 public ModelAndView Afterloginfailure()
	 {
	 
	     ModelAndView mv=new ModelAndView("LoginPage");
	     mv.addObject("invaliduser","invalid user name / password");
	     mv.addObject("loginform",new User());
	     return mv;
	 }
	 @RequestMapping("/afterlogin")
	 public String Afterloginsuccess(HttpSession session)
	 {
		 String pagename="";
		 SecurityContext securityContext=SecurityContextHolder.getContext();
		 Authentication authentication=securityContext.getAuthentication();
		
		 String nameId=authentication.getName();
		 session.setAttribute("un",nameId);
		 System.out.println(nameId);
	   
	  java.util.Collection<GrantedAuthority> grantedAuthorities=  (java.util.Collection<GrantedAuthority>) authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : grantedAuthorities) 
		{   System.out.println(grantedAuthority);
			String authority= grantedAuthority.getAuthority();
			if(authority.equals("ROLE_USER"))
			{
			     pagename="UserHome";	
			}
			else if(authority.equals("ROLE_ADMIN"))
			{
				pagename="home";
			}
			
			
		}
		return pagename;
	  
	 }
	 
	
	
	
	
	
	
	    
}
