package com.ani.eshopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.eshopbackend.daoimpl.CategoryDaoImpl;
import com.ani.eshopbackend.daoimpl.ProductDaoImpl;
import com.ani.eshopbackend.daoimpl.SupplierDaoImpl;
import com.ani.eshopbackend.model.Product;

@Controller
public class UserShowAllProductsController {
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	
	public UserShowAllProductsController() {
		
		System.out.println("UserShowAllProducts Controller is Loading");
		
	}
	@RequestMapping("/showallproduct")
	public ModelAndView goToShowProduct()
	{
		ModelAndView modelandview=new ModelAndView("UserShowAllProducts");
		   List<Product> listProduct = productDaoImpl.getProductList();
		 
		  modelandview.addObject("prolist", listProduct);
		return modelandview;
	}
	@RequestMapping("/viewdetails")
	public ModelAndView ViewProduct(@RequestParam("proid")int productid)
	   {
		   System.out.println("Product Id="+productid);
		  
		   Product product=productDaoImpl.getProduct(productid);
	
	 
		   ModelAndView modelandview=new ModelAndView("ShowParticularProduct");
		   
		  modelandview.addObject("pr",product);
		
		 
		   return modelandview;
	   }
	
	
	
	
	
}








