package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Database {
	private SuperUser superuser;
	private ArrayList<Warehouse> WarehousesList;
	private ArrayList<Warehouse> StoresList;
	private HashMap<String,WarehouseAdmin> WarehouseAdminMap;
	private HashMap<String,StoreAdmin> StoreAdminMap;
	private HashMap<String,String> LinkStoreWarehouse;
	private ArrayList<EndUser> EndUserMap;
	public void generateSuperUser() {
		String id="Superuser101";
		String password="#123@rt3ap10";
		superuser=new SuperUser(this,id,password);
	}
	//Setters and Getters
	/**
	 * @return the superuser
	 */
	public SuperUser getSuperuser() {
		return superuser;
	}
	/**
	 * @param superuser the superuser to set
	 */
	public void setSuperuser(SuperUser superuser) {
		this.superuser = superuser;
	}
	/**
	 * @return the warehousesList
	 */
	public ArrayList<Warehouse> getWarehousesList() {
		return WarehousesList;
	}
	/**
	 * @param warehousesList the warehousesList to set
	 */
	public void setWarehousesList(ArrayList<Warehouse> warehousesList) {
		WarehousesList = warehousesList;
	}
	/**
	 * @return the storesList
	 */
	public ArrayList<Warehouse> getStoresList() {
		return StoresList;
	}
	/**
	 * @param storesList the storesList to set
	 */
	public void setStoresList(ArrayList<Warehouse> storesList) {
		StoresList = storesList;
	}
	/**
	 * @return the warehouseAdminMap
	 */
	public HashMap<String, WarehouseAdmin> getWarehouseAdminMap() {
		return WarehouseAdminMap;
	}
	/**
	 * @param warehouseAdminMap the warehouseAdminMap to set
	 */
	public void setWarehouseAdminMap(HashMap<String, WarehouseAdmin> warehouseAdminMap) {
		WarehouseAdminMap = warehouseAdminMap;
	}
	/**
	 * @return the storeAdminMap
	 */
	public HashMap<String, StoreAdmin> getStoreAdminMap() {
		return StoreAdminMap;
	}
	/**
	 * @param storeAdminMap the storeAdminMap to set
	 */
	public void setStoreAdminMap(HashMap<String, StoreAdmin> storeAdminMap) {
		StoreAdminMap = storeAdminMap;
	}
	/**
	 * @return the linkStoreWarehouse
	 */
	public HashMap<String, String> getLinkStoreWarehouse() {
		return LinkStoreWarehouse;
	}
	/**
	 * @param linkStoreWarehouse the linkStoreWarehouse to set
	 */
	public void setLinkStoreWarehouse(HashMap<String, String> linkStoreWarehouse) {
		LinkStoreWarehouse = linkStoreWarehouse;
	}
	/**
	 * @return the endUserMap
	 */
	public ArrayList<EndUser> getEndUserMap() {
		return EndUserMap;
	}
	/**
	 * @param endUserMap the endUserMap to set
	 */
	public void setEndUserMap(ArrayList<EndUser> endUserMap) {
		EndUserMap = endUserMap;
	}
	//Setters and Getters end here
	
	
}
