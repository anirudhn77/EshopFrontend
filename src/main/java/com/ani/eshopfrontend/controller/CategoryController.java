package com.ani.eshopfrontend.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.eshopbackend.daoimpl.CategoryDaoImpl;
import com.ani.eshopbackend.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	public CategoryController()
	{
		System.out.println("Category Controller is loading ");
	}
	
	
	@RequestMapping(value="/addcategory" , method=RequestMethod.GET)
	public ModelAndView goToCategoryForm()
	{
		
		
		Category category=new Category();
		ModelAndView modelAndView=new ModelAndView("AddCategory");
		modelAndView.addObject("cat",category);
		modelAndView.addObject("cname","AddCategory");
		return modelAndView;
		
		
		
	}
	
	
	@RequestMapping(value="/addcategory" , method=RequestMethod.POST)
	public ModelAndView recieveCategoryFormData(@ModelAttribute("cat")Category category)
	{
		ModelAndView modelAndView=new ModelAndView("home");
		
		 System.out.println(category.getCategoryId());
	       System.out.println(category.getCategoryName());
	       System.out.println(category.getCategoryDescription());
	       
	       categoryDaoImpl.saveCategory(category);  
            
	       
	        
		return modelAndView;
		
	}
	
	@RequestMapping("showcategory")
	   public ModelAndView getCategoryList()
	   {
		   ModelAndView modelandview=new ModelAndView("ShowCategory");
		   List<Category> listCategory = categoryDaoImpl.getCategoryList();
		  
		 
		  modelandview.addObject("catlist", listCategory);
		   return modelandview;
		
	}
	
	@RequestMapping("/del")
	   public ModelAndView deleteCategory(@RequestParam("catid")int categoryid)
	   {
		   System.out.println("Category Id="+categoryid);
		  Category category=categoryDaoImpl.getCategory(categoryid);
		   categoryDaoImpl.deleteCategory(category);
		   ModelAndView modelandview=new ModelAndView("home");
		   List<Category> listCategory = categoryDaoImpl.getCategoryList();
		  
		 
		  modelandview.addObject("catlist", listCategory);
		   return modelandview;
	
	
}
	@RequestMapping("/edit")
	   public ModelAndView saveCategory(@RequestParam("catid")int categoryid)
	   {
		   System.out.println("Category Id="+categoryid);
		   Category category=categoryDaoImpl.getCategory(categoryid);
		 
		   ModelAndView modelandview=new ModelAndView("AddCategory");
		   
		  modelandview.addObject("cat",category);
		  modelandview.addObject("cname","UpdateCategory");
		   return modelandview;
		
	    
	}
		
	    
	
}
