package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public abstract class Admin {
	
	
	public Product search_product(String Product_Name) {
		//
		return null;
	}
	public void partial_search(String Partial_String) {
		
	}
	public abstract void add_new_product(String Product_name,double price);
	public abstract void update_product_info(String Product_name,double price,double D,double H,int K);
	public abstract void delete_product(String Product_name);
	public abstract void add_subcategory(String subcategory_name);
	public abstract void delete_subcategory(String subcategory_name);
	public abstract void update_subcategory_name(String subcategory_name);
	public abstract void add_category(String category_name);
	public abstract void delete_category(String category_name);
	public abstract void update_category_name(String category_name);
}
