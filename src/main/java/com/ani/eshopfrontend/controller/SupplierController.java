package com.ani.eshopfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.eshopbackend.daoimpl.SupplierDaoImpl;
import com.ani.eshopbackend.model.Category;
import com.ani.eshopbackend.model.Supplier;

@Controller
public class SupplierController {
	

		@Autowired
		SupplierDaoImpl supplierDaoImpl;
		
		public SupplierController()
		{
			System.out.println("Supplier Controller is loading ");
		}
		
		
		@RequestMapping(value="/addsupplier" , method=RequestMethod.GET)
		public ModelAndView goToSupplierForm()
		{
			
			
			Supplier supplier=new Supplier();
			ModelAndView modelAndView=new ModelAndView("AddSupplier");
			modelAndView.addObject("sup",supplier);
			modelAndView.addObject("sname","AddSupplier");
			
			return modelAndView;
			
			
			
		}
		
		
		@RequestMapping(value="/addsupplier" , method=RequestMethod.POST)
		public ModelAndView recieveSupplierFormData(@ModelAttribute("sup")Supplier supplier)
		{
			ModelAndView modelAndView=new ModelAndView("home");
			
			   System.out.println(supplier.getSupplierId());
		       System.out.println(supplier.getSupplierName());
		       System.out.println(supplier.getSupplierAddress());
		       System.out.println(supplier.getSupplierAddress());
		       
		       supplierDaoImpl.saveSupplier(supplier);  
	            
		       
		        
			return modelAndView;
			
		}
		
		@RequestMapping("showsupplier")
		   public ModelAndView getSupplier()
		   {
			 ModelAndView modelandview=new ModelAndView("ShowSupplier");
			   List<Supplier> listSupplier = supplierDaoImpl.getSupplier();
			  
			 
			  modelandview.addObject("suplist", listSupplier);
			   return modelandview;
			
		}
		
		 @RequestMapping("/dele")
		   public ModelAndView deleteSupplier(@RequestParam("supid")int supplierid)
		   {
			   System.out.println("Supplier Id="+supplierid);
			   Supplier supplier=supplierDaoImpl.getSupplier(supplierid);
			   supplierDaoImpl.deleteSupplier(supplier);
			   ModelAndView modelandview=new ModelAndView("home");
			   List<Supplier> listSupplier = supplierDaoImpl.getSupplier();
			  
			 
			  modelandview.addObject("suplist", listSupplier);
			   return modelandview;
		}
		   @RequestMapping("/edt")
		   public ModelAndView editsupplier(@RequestParam("supid")int supplierid)
		   {
			   System.out.println("Supplier Id="+supplierid);
			   Supplier supplier=supplierDaoImpl.getSupplier(supplierid);
			 
			   ModelAndView modelandview=new ModelAndView("AddSupplier");
			   
			  modelandview.addObject("sup",supplier);
			  modelandview.addObject("sname","UpdateSupplier");
			   return modelandview;
		   }
		}