package com.ani.eshopfrontend.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.ani.eshopbackend.model.Product;

public class Utilityfileupload {
	
	public void fileUpload(@ModelAttribute ("pro") Product pr)
	{
	
	MultipartFile multi=pr.getProimage();
	  System.out.println("-------------------------------------"+multi);
	 /* System.out.println(pr.getProductID());
     System.out.println(pr.getProductName());
     System.out.println(pr. getProductDescription());
     System.out.println(pr. getProductCategory());SSSSS
     System.out.println(pr. getProductSupplier());*/
 try {
	  byte b[]=multi.getBytes(); 
	FileOutputStream fos= new FileOutputStream("D:\\EshopProject\\eshopfrontend\\src\\main\\webapp\\resources\\"+pr.getProductID()+".jpg");
	BufferedOutputStream bos= new BufferedOutputStream(fos);
	bos.write(b);
	bos.close();
	
	
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}