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
