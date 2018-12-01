package application;
import java.util.*;
import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.*;import javafx.stage.*;import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Cart {
	private final EndUser Owner;
	private Map<String,Integer> QuantityMap;
	private ArrayList<String> Product;
	private double TotalValue;
	private Map<String,Integer> Carts;
	
	/**
	 * @param owner
	 */
	public Cart(EndUser owner) {
		super();
		Owner = owner;
		this.TotalValue=0;
	}
	public void Add_to_Cart(String Product_Name,int Quantity) {
		this.Cart.Carts.put(Product_Name,Quantity);
		
	}
	public void Remove_from_Cart(String Product_Name) {
		this.Cart.Carts.remove(Product_Name);
		
	}
	public void Checkout() 
	{	
		if(this.Cart.Carts.getValue()< this.Owner.SelectStore().sInventory().Search_Product().getQuantity())
		{
			System.out.println("You cannot take this product");
		}
		else
		{
			this.TotalValue=this.TotalValue + (this.Owner.SelectStore().sInventory().Search_Product().getPrice())*(this.Owner.SelectStore().sInventory().Search_Product().getQuantity());
		}
		if(this.Cart.TotalValue > this.Owner.Funds)
		{
			System.out.println("You cannot make the purchase");
		}
		else
		{
			System.out.println("Purchase is complete");
			this.Owner.Funds=this.Owner.Funds - this.Cart.TotalValue;
			// reduce() function to be implemented later.
			// reduce(product name,product quantity)
			//This will reduce the quantity of products in product list by the quantity of product purchased
			this.Carts.getValue().reduce(this.Owner.SelectStore().sInventory().Search_Product().getProd_Name(),this.Owner.SelectStore().sInventory().Search_Product().getQuantity());
																																						
		}
		}
}

