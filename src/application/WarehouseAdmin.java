package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class WarehouseAdmin extends Admin{
	private final String Warehouse_Admin_Name;
	private final String Warehouse_Admin_ID;//ID of the warehouse Admin will be of the form wa1,wa2,wa3....
	private final String Password;
	private final Warehouse WarehouseIncharge;
	
	private ArrayList<Warehouse> Warehouses;
	
	public WarehouseAdmin(String warehouse_Admin_Name, String warehouse_Admin_ID,String Password ,Warehouse warehouseIncharge) {
		super();
		Warehouse_Admin_Name = warehouse_Admin_Name;
		Warehouse_Admin_ID = warehouse_Admin_ID;
		this.Password=Password;
		WarehouseIncharge = warehouseIncharge;
	}
	//All of these functions are necessary to be here as they are implemented by Warehouse Admin
	
	//-------------------------Category Functions-------------------------
	
	@Override
	public void add_category(String category_name) {
		this.getWarehouseIncharge().getWInventory().Add_Category(category_name);
	}
	@Override
	public void delete_category(String category_name) {
		this.getWarehouseIncharge().getWInventory().delete_category(category_name);
	}
	@Override
	public void update_category_name(String category_name,String new_name) {
		this.getWarehouseIncharge().getWInventory().update_category_name(category_name, new_name);
	}
	
	//--------------------------Subcategory Functions---------------------------
	
	@Override
	public void add_subcategory(String subcategory_name,String path) {
		this.getWarehouseIncharge().getWInventory().add_subcategory(subcategory_name,path);
	}
	@Override
	public void delete_subcategory(String subcategory_name) {
		this.getWarehouseIncharge().getWInventory().delete_subcategory(subcategory_name);
	}
	@Override
	public void update_subcategory_name(String subcategory_name,String new_name) {
		this.getWarehouseIncharge().getWInventory().update_subcategory_name(subcategory_name, new_name);
	}
	
	//--------------------------Product Functions---------------------------------
	
	@Override
	public void add_new_product(String Product_name,String path,int quantity,double price,double D,double H,int K,String Description) {
		this.getWarehouseIncharge().getWInventory().add_new_product(Product_name,path,quantity, price,D,H,K,Description);
	}
	@Override
	public void update_product_info(String Product_name,String new_name,int quantity,double new_price,double new_fixed,double new_demand,int new_carry,String Descp) {
		this.getWarehouseIncharge().getWInventory().Update_Product(Product_name, new_name, quantity, new_price, new_fixed, new_demand, new_carry, Descp);
	}
	@Override
	public void delete_product(String Product_name) {
		this.getWarehouseIncharge().getWInventory().delete_product(Product_name);
	}
	
	
	/**
	 * @return the warehouses
	 */
	public ArrayList<Warehouse> getWarehouses() {
		return Warehouses;
	}
	/**
	 * @param warehouses the warehouses to set
	 */
	public void setWarehouses(ArrayList<Warehouse> warehouses) {
		Warehouses = warehouses;
	}
	/**
	 * @return the warehouse_Admin_Name
	 */
	public String getWarehouse_Admin_Name() {
		return Warehouse_Admin_Name;
	}
	/**
	 * @return the warehouse_Admin_ID
	 */
	public String getWarehouse_Admin_ID() {
		return Warehouse_Admin_ID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @return the warehouseIncharge
	 */
	public Warehouse getWarehouseIncharge() {
		return WarehouseIncharge;
	}
	
}
