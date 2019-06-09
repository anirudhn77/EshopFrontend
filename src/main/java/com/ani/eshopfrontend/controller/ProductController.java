package com.ani.eshopfrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ani.eshopbackend.daoimpl.CategoryDaoImpl;
import com.ani.eshopbackend.daoimpl.ProductDaoImpl;
import com.ani.eshopbackend.daoimpl.SupplierDaoImpl;
import com.ani.eshopbackend.model.Category;
import com.ani.eshopbackend.model.Product;
import com.ani.eshopbackend.model.Supplier;
import com.ani.eshopfrontend.utility.Utilityfileupload;






@Controller
public class ProductController
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
@RequestMapping(value="/addproduct",method=RequestMethod.GET)

   
   public ModelAndView goToProductForm()
   {
       ModelAndView  mv=new ModelAndView("AddProduct");
       Product product=new Product();
       int id=(int)(Math.random()*10000);
       product.setProductID(id);
       
       
       mv.addObject("pro",product);
       List<Supplier> listSupplier = supplierDaoImpl.getSupplier();
 	  
  	 
 	  mv.addObject("suplist", listSupplier);
	   
      // mv.addObject("pro",new Products());
       List<Category> listCategory = categoryDaoImpl.getCategoryList();
 	  
  	 
 	  mv.addObject("catlist", listCategory);
       mv.addObject("bname","AddProducts");

       return  mv;
   }

   @RequestMapping(value="/addproduct",method=RequestMethod.POST)
   public String recieveProductFormData(@ModelAttribute ("pro") Product pr)
   {
	  
       Utilityfileupload utilityfileupload=new Utilityfileupload();
       utilityfileupload.fileUpload(pr);
       productDaoImpl.saveProduct(pr);
       return "home";
      
   }
   @RequestMapping("/showproduct")
   public ModelAndView rerieveProduct( )
   {
	   ModelAndView modelandview=new ModelAndView("ShowProduct");
	   List<Product> listProduct = productDaoImpl.getProductList();
	   
	   List<Supplier> listSupplier = supplierDaoImpl.getSupplier();
	 	  
	  	 
	 	  modelandview.addObject("suplist", listSupplier);
	  	 
	 
	  modelandview.addObject("prolist", listProduct);
	   return modelandview;
   }
   @RequestMapping("/delete")
   public ModelAndView deleteProduct(@RequestParam("proid")int productid)
   {
	   System.out.println("Product Id="+productid);
	   
	   Product product=productDaoImpl.getProduct(productid);
	   productDaoImpl.deleteProduct(product);
	   File file=new File("D:\\EshopProject\\eshopfrontend\\src\\main\\webapp\\resources\\"+product.getProductID()+".jpg");
	   file.delete();
	   ModelAndView modelandview=new ModelAndView("home");
	   List<Product> listProduct = productDaoImpl.getProductList();
	  
	 
	  modelandview.addObject("prolist", listProduct);
	   return modelandview;
}
   @RequestMapping("/ed")
   public ModelAndView editProduct(@RequestParam("proid")int productid)
   {
	   System.out.println("Product Id="+productid);
	   Product product=productDaoImpl.getProduct(productid);
	 
	   ModelAndView modelandview=new ModelAndView("AddProduct");
	   List<Category> listCategory = categoryDaoImpl.getCategoryList();
	   List<Supplier> listSupplier = supplierDaoImpl.getSupplier();
	 	  
	  	 
	 	  modelandview.addObject("suplist", listSupplier);
	  	 
	 	  modelandview.addObject("catlist", listCategory);
	  modelandview.addObject("pro",product);
	  modelandview.addObject("bname","UpdateProduct");
	   return modelandview;
   }
}