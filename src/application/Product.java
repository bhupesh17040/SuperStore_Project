package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
/**
 * @author Nirav Diwan
 *
 */
public class Product {
	private final Subcategory Subcat;
	private String Prod_Name;//Name of Product
	private final String Prod_ID;//Unique ID of Product is of the form s3-c1-b2-p1 or w3-c3-b3-p8
	private final String Prod_Path;//Product Path is of the path Store/Warehouse_ID> Category_ID>Subcategory_ID
	private double price;
	private int quantity;
	//Eg-"s11>c2>c3"
									
	private double Fixed_Price;// Fixed_Price is fixed Price(D) per quarter 
	private double Carry_Cost;// Carry_Cost is carry_cost(H) per quarter	
	private int Demand;// Demand of items(K) in units per quarter.			
	private int Count_of_Products=0;
	private String Description;
	
	public Product(Subcategory subcat,String prod_Name,String path,String Product_ID,int quantity,double price,double Fixed_Price,double Carry_Cost,int Demand,String Descp) {
		this.Subcat=subcat;
		this.Prod_Name = prod_Name;
		this.Prod_ID=Product_ID;
		this.quantity=quantity;
		this.Fixed_Price=Fixed_Price;
		this.Prod_Path=path;
		this.price=price;
		this.Carry_Cost=Carry_Cost;
		this.Demand=Demand;
		this.Description=Descp;
	}
	 /**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void ssetQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the subcat
	 */
	public Subcategory getSubcat() {
		return Subcat;
	}
	/**
	 * returns the economic order quantity (EOQ) i.e. the 
	 * number of units superstore should be adding to inventory order.
	 * @return eoq economic order quantity(EOQ)
	 */
	public double calculateEOQ() {
		 double x=2*this.Fixed_Price*this.Demand;
		 double eoq=x/this.Carry_Cost;
		 eoq=Math.sqrt(eoq);
		 return eoq;
	 }
	//Setters and getters start here
	/**
	 * @return the prod_Price
	 */
	
	/**
	 * @return the fixed_Price
	 */
	public double getFixed_Price() {
		return Fixed_Price;
	}
	/**
	 * @param fixed_Price the fixed_Price to set
	 */
	public void setFixed_Price(double fixed_Price) {
		Fixed_Price = fixed_Price;
	}
	/**
	 * @return the carry_Cost
	 */
	public double getCarry_Cost() {
		return Carry_Cost;
	}
	/**
	 * @param carry_Cost the carry_Cost to set
	 */
	public void setCarry_Cost(double carry_Cost) {
		Carry_Cost = carry_Cost;
	}
	/**
	 * @return the demand
	 */
	public int getDemand() {
		return Demand;
	}
	/**
	 * @param demand the demand to set
	 */
	public void setDemand(int demand) {
		Demand = demand;
	}
	/**
	 * @return the count_of_Products
	 */
	public int getCount_of_Products() {
		return Count_of_Products;
	}
	/**
	 * @param count_of_Products the count_of_Products to set
	 */
	public void setCount_of_Products(int count_of_Products) {
		Count_of_Products = count_of_Products;
	}
	/**
	 * @return the prod_Name
	 */
	public String getProd_Name() {
		return Prod_Name;
	}
	/**
	 * @return the prod_ID
	 */
	public String getProd_ID() {
		return Prod_ID;
	}
	/**
	 * @return the prod_Path
	 */
	public String getProd_Path() {
		return Prod_Path;
	}
	//Setters and getters end here
	/**
	 * @param prod_Name the prod_Name to set
	 */
	public void setProd_Name(String prod_Name) {
		Prod_Name = prod_Name;
	}

	
}
