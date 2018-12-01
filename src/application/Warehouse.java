package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Warehouse {
	private final String Warehouse_Name;
	private final String Warehouse_ID;
	private WarehouseAdmin WAdmin;
	

	private Inventory WInventory;
	private ArrayList<Store> StoresLinked=new ArrayList<Store>();
	public Warehouse(String warehouse_Name, String warehouse_ID) {
		super();
		Warehouse_Name = warehouse_Name;
		Warehouse_ID = warehouse_ID;
		WInventory=new Inventory(this,this.Warehouse_ID,this.Warehouse_Name);
	}

	/**
	 * @return the wInventory
	 */
	public Inventory getWInventory() {
		return WInventory;
	}

	/**
	 * @param wInventory the wInventory to set
	 */
	public void setWInventory(Inventory wInventory) {
		WInventory = wInventory;
	}

	/**
	 * @return the storesLinked
	 */
	public ArrayList<Store> getStoresLinked() {
		return StoresLinked;
	}

	

	/**
	 * @return the warehouse_Name
	 */
	public String getWarehouse_Name() {
		return Warehouse_Name;
	}

	/**
	 * @return the warehouse_ID
	 */
	public String getWarehouse_ID() {
		return Warehouse_ID;
	}

	/**
	 * @return the wAdmin
	 */
	public WarehouseAdmin getWAdmin() {
		return WAdmin;
	}
	
	/**
	 * @param wAdmin the wAdmin to set
	 */
	public void setWAdmin(WarehouseAdmin wAdmin) {
		WAdmin = wAdmin;
	}

	
}
