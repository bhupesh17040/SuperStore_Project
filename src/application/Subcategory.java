package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Subcategory {
	private final Category category;
	private String Subcategory_Name;
	private final String Subcategory_ID;//of the form s1-c2-b3 or w1-c3-b5
	private final String Subcategory_Path;//Store//Warehouse_ID
	private ArrayList<Product> Product_List;
	private int Number_of_Products;
	public Subcategory(Category cat,String subcategory_Name, String subcategory_ID, String subcategory_Path) {
		this.category=cat;
		Subcategory_Name = subcategory_Name;
		Subcategory_ID = subcategory_ID;
		Subcategory_Path = subcategory_Path;
	}
	
	public Product Add_Product(String Product_Name,double price) {
		String new_prod_ID=this.Generate_New_Product_ID(this.Subcategory_Path);
		String new_prod_Path=this.Subcategory_Path+">"+this.Subcategory_Name;
		Product new_product=new Product(this,Product_Name,new_prod_Path,new_prod_ID,price);
		this.Product_List.add(new_product);
		return new_product;
	}
	public String delete_product(String Product_Name) {
		int t=0;
		for(int i=0;i<Product_List.size();i++) {
			if(this.Product_List.get(i).getProd_Name().equals(Product_Name)) {
				t=i;
				break;
		}}
		String name=Product_List.get(t).getProd_Name();
		this.Product_List.remove(t);
		return name;
	}
	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}
	// Getters and Setters 	start here
	/**returns the ID of the new Product ID 
	 * @return new_ID ID of the new Product to be generated;
	 */
	public String Generate_New_Product_ID(String path) {
		String new_ID=this.getSubcategory_ID()+"-p"+Number_of_Products;
		Number_of_Products++;
		return new_ID;
	}
	/**
	 * @return the product_List
	 */
	public ArrayList<Product> getProduct_List() {
		return Product_List;
	}
	/**
	 * @param product_List the product_List to set
	 */
	public void setProduct_List(ArrayList<Product> product_List) {
		Product_List = product_List;
	}

	/**
	 * @return the number_of_Products
	 */
	public int getNumber_of_Products() {
		return Number_of_Products;
	}
	/**
	 * @param number_of_Products the number_of_Products to set
	 */
	public void setNumber_of_Products(int number_of_Products) {
		Number_of_Products = number_of_Products;
	}
	/**
	 * @return the subcategory_Name
	 */
	public String getSubcategory_Name() {
		return Subcategory_Name;
	}
	/**
	 * @return the subcategory_ID
	 */
	public String getSubcategory_ID() {
		return Subcategory_ID;
	}
	/**
	 * @return the cat
	 */
	public Category getCat() {
		return category;
	}
	/**
	 * @return the subcategory_Path
	 */
	public String getSubcategory_Path() {
		return Subcategory_Path;
	} 
	//Getters and setters end here
	/**
	 * @param subcategory_Name the subcategory_Name to set
	 */
	public void setSubcategory_Name(String subcategory_Name) {
		Subcategory_Name = subcategory_Name;
	}
	
	
}
