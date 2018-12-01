package application;
import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.*;import javafx.stage.*;import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Category {
	private final Inventory inv;
	private String Category_Name;
	private final String Category_ID;//of the form s1-c2 or w1-c3
	private final String Category_Path;//Store/Warehouse_ID 
	private ArrayList<Subcategory> Subcategory_List;
	private int Number_of_Subcategory;
	public Category(Inventory inv,String category_Name,String category_ID,String category_Path) {
		this.inv=inv;
		this.Category_Name = category_Name;
		this.Category_ID=category_ID;
		this.Category_Path = category_Path;
		Number_of_Subcategory=0;
		Subcategory_List=new ArrayList<Subcategory>();
	}
	public Subcategory Add_Subcategory(String Subcategory_Name) {
		
		String new_sub_ID=this.Generate_New_Subcategory_ID();
		String new_sub_Path=this.Category_Path+">"+this.Category_Name;
		System.out.println("	Creating Subcategory in "+new_sub_Path);
		Subcategory new_subcategory=new Subcategory(this,Subcategory_Name,new_sub_ID,new_sub_Path);
		this.Subcategory_List.add(new_subcategory);
		System.out.println("	Added to "+this.Category_Name+" Subcategories Lists");
		return new_subcategory;
	}
	/**returns the ID of the new Subcategory ID 
	 * @return new_ID ID of the new Subcategory to be generated;
	 */
	public String Generate_New_Subcategory_ID() {
		String new_ID=this.getCategory_ID()+"-b"+Number_of_Subcategory;
		Number_of_Subcategory++;
		return new_ID;
	}
	
	public void print_details() {
		System.out.println("Category Name:"+this.Category_Name);
		System.out.println("Category ID:"+this.Category_ID);
		System.out.println("Category Path:"+this.Category_Path);
		System.out.println("Subactegories:");
		System.out.println("Number of Subcategories:"+
		this.getSubcategory_List().size());
		for(int i=0;i<this.getSubcategory_List().size();i++) {
			System.out.print(i);
			this.getSubcategory_List().get(i).print_details();
			
		}
	}
	
	
	//Setters and getters start here
	/**
	 * @return the subcategory_List
	 */
	public String delete_subcategory(String Subcategory_Name) {
		int t=0;
		for(int i=0;i<Subcategory_List.size();i++) {
			if(Subcategory_List.get(i).getSubcategory_Name().equals(Subcategory_Name))
			t=i;
			System.out.println("	Found the Subcategory to Delete");
			break;
		}
		String name=this.Subcategory_List.get(t).getSubcategory_Name();
		this.Subcategory_List.remove(t);
		System.out.println("	Removed from "+this.getCategory_Name()+"Subcategories List");
		return name;
	}
	
	public ArrayList<Subcategory> getSubcategory_List() {
		return Subcategory_List;
	}
	/**
	 * @param subcategory_List the subcategory_List to set
	 */
	public void setSubcategory_List(ArrayList<Subcategory> subcategory_List) {
		Subcategory_List = subcategory_List;
	}
	/**
	 * @return the number_of_Subcategory
	 */
	public int getNumber_of_Subcategory() {
		return Number_of_Subcategory;
	}
	/**
	 * @param number_of_Subcategory the number_of_Subcategory to set
	 */
	public void setNumber_of_Subcategory(int number_of_Subcategory) {
		Number_of_Subcategory = number_of_Subcategory;
	}
	/**
	 * @return the category_Name
	 */
	public String getCategory_Name() {
		return Category_Name;
	}
	/**
	 * @return the category_ID
	 */
	public String getCategory_ID() {
		return Category_ID;
	}
	/**
	 * @return the category_Path
	 */
	public String getCategory_Path() {
		return Category_Path;
	} 
	/**
	 * @return the inv
	 */
	public Inventory getInv() {
		return inv;
	}
	/**
	 * @param category_Name the category_Name to set
	 */
	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}
	//Setters  and Getters end here
	
	
	
	
}
