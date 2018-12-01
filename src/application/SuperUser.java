package application;

import java.util.ArrayList;
import java.util.HashMap;

public class SuperUser {
	
	private final Database dbt;
	private final String superuserID;
	private final String password;

	/**
	 * @param dbt
	 * @param superuserID
	 * @param password
	 */
	public SuperUser(Database dbt, String superuserID, String password) {
		super();
		this.dbt = dbt;
		this.superuserID = superuserID;
		this.password = password;
	}
	public void CreateWarehouse(String W_Name,String W_ID) {
		 this.dbt.create_warehouse(W_Name,W_ID);
	}
	public void CreateStore(String S_Name,String S_ID) {
		 this.dbt.create_store(S_Name,S_ID);
	}
	public void CreateWarehouseAdmin(String W_Admin_Name,String W_Admin_ID,String W_Admin_Password) {
		this.dbt.create_warehouseadmin(W_Admin_Name,W_Admin_ID,W_Admin_Password);
	}
	public void CreateStoreAdmin(String S_Admin_Name,String S_Admin_ID,String S_Admin_Password) 
	{
		 this.dbt.create_storeadmin(S_Admin_Name,S_Admin_ID,S_Admin_Password);
	}
	public void LinkStoreWarehouse(String Store_Name,String Warehouse_name) 
	{
		this.dbt.linkstorewarehouse(Store_Name,Warehouse_name);
	}
	/**
	 * @return the dbt
	 */
	public Database getDbt() {
		return dbt;
	}
	/**
	 * @return the superuserID
	 */
	public String getSuperuserID() {
		return superuserID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	} 
	
	
}

