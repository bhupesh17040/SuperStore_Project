package application;
import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.*;import javafx.stage.*;import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;

public final class EndUser {
	private final String EndUser_Name;
	private final String EndUser_ID;
	private String email;
	private Cart guest_cart;
	private Store Current_Store;
	private Double Funds;
	/**
	 * @param endUser_Name
	 * @param endUser_ID
	 * @param email
	 */
	public EndUser(String endUser_Name, String endUser_ID, String email) {
		super();
		EndUser_Name = endUser_Name;
		EndUser_ID = endUser_ID;
		this.email = email;
		this.guest_cart=new Cart(this);
	}
	public void SelectStore(Store store) {
		this.Current_Store=store;
	}
	public void add_funds(Double New_Funds) {
		this.Funds=this.Funds+New_Funds;
	}
	public void Add_to_Cart(String Product_Name,int Quantity) {
		this.guest_cart.Add_to_Cart(Product_Name,Quantity);
	}
	public void Remove_from_Cart(String Product_Name) {
		this.guest_cart.Remove_from_Cart(Product_Name);
		
	}
	public void Checkout() {
		this.guest_cart.Checkout();
	}
	
}

