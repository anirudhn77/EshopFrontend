package com.ani.eshopfrontend.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.eshopbackend.daoimpl.CartDaoImpl;
import com.ani.eshopbackend.daoimpl.ProductDaoImpl;
import com.ani.eshopbackend.model.Cart;
import com.ani.eshopbackend.model.Product;

@Controller
public class CartController {
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
@Autowired
CartDaoImpl cartDaoimpl;
	@RequestMapping("/addtocart")
	public ModelAndView SaveCartData(HttpServletRequest request,HttpSession session)
	   {
		
		
		String UserName=(String)session.getAttribute("un");
		
		int x=Integer.parseInt(request.getParameter("p"));
		int y=Integer.parseInt(request.getParameter("q"));
        System.out.println(x);
        System.out.println(y);
        
        
		
			
		//testing productid
		  // System.out.println("Product Id="+productid);
		  ///getting enire product data
		   Product product=productDaoImpl.getProduct(x);
	       
		   Cart cart=cartDaoimpl.setCart(product,y,UserName);
		 cartDaoimpl.saveCart(cart);
		   System.out.println("sssssssssssss"+cart.getCartdId());
		   List<Cart> cartlist=cartDaoimpl.getCartList(UserName);
		   System.out.println("-----------------   cartlist");
		 
		 System.out.println("----------------------   savecart");
		 ModelAndView modelandview=new ModelAndView("UserHome");
		 modelandview.addObject("cartlist",cartlist);
		   return modelandview;
	   }
	
	
	
	@RequestMapping("/displayusercartdetails")
	public ModelAndView retrieveAllCartData(HttpSession httpsession)
	{
		String UserName=(String)httpsession.getAttribute("un");
		ModelAndView modelAndView=new ModelAndView("UserCartDetails");
	List<Cart> cartdata=cartDaoimpl.getCartList(UserName);
	modelAndView.addObject("cartlist",cartdata);
		return modelAndView;
	}
	
	
	//----------------------------------------------------------------
	
	//       DELETE CART PARICULAR ITEM
	  
	
	@RequestMapping("/deletecart")
	   public String deletecart(@RequestParam("cartid")int cartid)
	   {
		   System.out.println("Cart Id="+cartid);
		   Cart cart=cartDaoimpl.getCart(cartid);
		   cartDaoimpl.deleteCart(cart);
		   
		   
		   
		   //ModelAndView modelandview=new ModelAndView("UserCartDetails");
		   
		   //List<Cart> cartlist=cartDaoimpl.getCartList(UserName);
		 
		  //modelandview.addObject("cartlist", cartlist);
		   
		   
		   
		   return "redirect:displayusercartdetails";
	}
	
	
	
}


