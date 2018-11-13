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
	
	
}
