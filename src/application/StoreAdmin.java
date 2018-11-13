package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class StoreAdmin extends Admin{
	private final String Store_Admin_Name;
	private final String Store_Admin_ID;//ID of the warehouse Admin will be of the form sa1,sa2,sa3....
	private final String Password;
	private Store StoreIncharge;
	
	public StoreAdmin(String store_Admin_Name, String store_Admin_ID, String Password,Store storeIncharge) {
		Store_Admin_Name = store_Admin_Name;
		Store_Admin_ID = store_Admin_ID;
		StoreIncharge = storeIncharge;
		this.Password=Password;
	}
	//All of these functions are necessary to be here as they are implemented by Warehouse Admin
	@Override
	public void add_new_product(String Product_name,double price) {

	}
	@Override
	public void update_product_info(String Product_name,double price,double D,double H,int K) {
		
	}
	@Override
	public void delete_product(String Product_name) {
		
	}
	@Override
	public void add_subcategory(String subcategory_name) {
		
	}
	@Override
	public void delete_subcategory(String subcategory_name) {
		
	}
	@Override
	public void update_subcategory_name(String subcategory_name) {
		
	}
	@Override
	public void add_category(String category_name) {
		
	}
	@Override
	public void delete_category(String category_name) {
		
	}
	@Override
	public void update_category_name(String category_name) {
		
	}
}
