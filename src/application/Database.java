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
	private ArrayList<EndUser> EndUserMap;
}
