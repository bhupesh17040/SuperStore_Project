package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public abstract class Admin {
	
	//----------------------------Category Functions-----------------------------
	public abstract void add_category(String category_name);
	public abstract void delete_category(String category_name);
	public abstract void update_category_name(String category_name,String new_name);
	
	//----------------------------Subcategory Functions-----------------------------
	
	public abstract void add_subcategory(String subcategory_name,String path);
	public abstract void delete_subcategory(String subcategory_name);
	public abstract void update_subcategory_name(String subcategory_name,String new_name);
	
	//----------------------------Product Functions-----------------------------
	
	public abstract void add_new_product(String Product_name,String path,int quantity,double price,double D,double H,int K,String Description);
	public abstract void update_product_info(String Product_name,String new_name,int quantity,double new_price,double new_fixed,double  new_carry,int new_demand,String Descp);
	public abstract void delete_product(String Product_name);
	
	
}
