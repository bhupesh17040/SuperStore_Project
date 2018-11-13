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
	private final WarehouseAdmin WAdmin;
	private Inventory WInventory;
	private ArrayList<String> StoresLinked;
	
	public Warehouse(String warehouse_Name, String warehouse_ID, WarehouseAdmin wAdmin) {
		super();
		Warehouse_Name = warehouse_Name;
		Warehouse_ID = warehouse_ID;
		WAdmin = wAdmin;
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
	public ArrayList<String> getStoresLinked() {
		return StoresLinked;
	}

	/**
	 * @param storesLinked the storesLinked to set
	 */
	public void setStoresLinked(ArrayList<String> storesLinked) {
		StoresLinked = storesLinked;
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
	
	

	
}
