package application;
import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.*;import javafx.stage.*;import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Cart {
	private final EndUser Owner;
	private Map<String,Integer> QuantityMap;
	private ArrayList<String> Product;
	private double TotalValue;
	/**
	 * @param owner
	 */
	public Cart(EndUser owner) {
		super();
		Owner = owner;
		this.TotalValue=0;
	}
	public void Add_to_Cart(String Product_Name,int Quantity) {
		
	}
	public void Remove_from_Cart(String Product_Name) {
		
	}
	public void Checkout() {
		
	}

	
	
}
