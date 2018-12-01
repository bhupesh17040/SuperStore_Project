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
	
	

	public boolean check_product_in_warehouse(String Product_Name) {
	if (this.getStoreIncharge().getLinkedWarehouse().getWInventory().getProductPathMap().containsKey(Product_Name)){
			return true;
		}
	return false;
	}
	
	
	
	
	
	//All of these functions are necessary to be here as they are implemented by  Admin
	@Override
	public void add_category(String category_name) {
		this.getStoreIncharge().getsInventory().Add_Category(category_name);
	}
	@Override
	public void delete_category(String category_name) {
		this.getStoreIncharge().getsInventory().delete_category(category_name);
	}
	@Override
	public void update_category_name(String category_name,String new_name) {
		this.getStoreIncharge().getsInventory().update_category_name(category_name, new_name);
	}
	
	@Override
	public void add_subcategory(String subcategory_name,String path) {
		this.getStoreIncharge().getsInventory().add_subcategory(subcategory_name,path);
	}
	@Override
	public void delete_subcategory(String subcategory_name) {
		this.getStoreIncharge().getsInventory().delete_subcategory(subcategory_name);
	}
	@Override
	public void update_subcategory_name(String subcategory_name,String new_name) {
		this.getStoreIncharge().getsInventory().update_subcategory_name(subcategory_name, new_name);
	}
	
	@Override
	public void add_new_product(String Product_name,String path,int quantity,double price,double D,double H,int K,String Desc) {
		if(this.check_product_in_warehouse(Product_name)) {
		this.getStoreIncharge().getsInventory().add_new_product(Product_name, path, quantity, price, D, H, K,Desc);
		}
		else {
			System.out.println("Product Does not Exist in Linked Warehouse so cannot be added");
		}
	}
	@Override
	public void update_product_info(String Product_name,String new_name,int quantity,double new_price,double new_fixed,double new_carry,int new_demand,String Descp) {
		this.getStoreIncharge().getsInventory().Update_Product(Product_name, new_name, quantity, new_price, new_fixed, new_carry, new_demand, Descp);
	}
	@Override
	public void delete_product(String Product_name) {
		this.getStoreIncharge().getsInventory().delete_product(Product_name);
	}
	
	
	
	
	//Getters and Setters Start here

	/**
	 * @return the storeIncharge
	 */
	public Store getStoreIncharge() {
		return StoreIncharge;
	}


	/**
	 * @param storeIncharge the storeIncharge to set
	 */
	public void setStoreIncharge(Store storeIncharge) {
		StoreIncharge = storeIncharge;
	}


	/**
	 * @return the store_Admin_Name
	 */
	public String getStore_Admin_Name() {
		return Store_Admin_Name;
	}


	/**
	 * @return the store_Admin_ID
	 */
	public String getStore_Admin_ID() {
		return Store_Admin_ID;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	
	
}
