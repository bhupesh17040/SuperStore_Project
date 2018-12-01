package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Store {
	private final String Store_Name;
	private final String Store_ID;
	private StoreAdmin sAdmin;
	private final Inventory sInventory;
	private Warehouse LinkedWarehouse;
	public Store(String store_Name, String store_ID) {
		this.Store_Name = store_Name;
		this.Store_ID = store_ID;
		this.sInventory=new Inventory(this,this.Store_ID,this.Store_Name);
	}
	public ArrayList<String> partial_search(String s) {
		return this.getsInventory().Partial_Search(s);
		
	}
	/**
	 * @return the wInventory
	 */
	public Inventory getsInventory() {
		return sInventory;
	}
	
	/**
	 * @return the linkedWarehouse
	 */
	public Warehouse getLinkedWarehouse() {
		return LinkedWarehouse;
	}
	/**
	 * @param linkedWarehouse the linkedWarehouse to set
	 */
	public void setLinkedWarehouse(Warehouse linkedWarehouse) {
		LinkedWarehouse = linkedWarehouse;
	}
	/**
	 * @return the store_Name
	 */
	public String getStore_Name() {
		return Store_Name;
	}
	/**
	 * @return the store_ID
	 */
	public String getStore_ID() {
		return Store_ID;
	}
	/**
	 * @return the sAdmin
	 */
	public StoreAdmin getsAdmin() {
		return sAdmin;
	}

	/**
	 * @param sAdmin the sAdmin to set
	 */
	public void setsAdmin(StoreAdmin sAdmin) {
		this.sAdmin = sAdmin;
	}
	
}
