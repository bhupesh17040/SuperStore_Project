package application;
import javafx.application.Application;import javafx.fxml.FXMLLoader;import javafx.*;import javafx.stage.*;import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Inventory {
	private final Object Lead;//Trying to use Polymorphism here
	private final String LeadID;
	private final String LeadName;
	private ArrayList<Category> CategoryList;
	private HashMap<String,String> ProductPathMap=new HashMap<String,String>();//Eg.-Sony_headphones,StoreName>Electronics>Headphones
	private HashMap<String,String> SubcategoryPathMap=new HashMap<String,String>();//Eg.-Headphones,StoreName>Electronics
	private  int Number_of_Categories;
	
	public Inventory(Object lead,String leadID,String leadName) {//Polymorphism
		Number_of_Categories=0;
		if(lead!=null && lead.getClass()==Warehouse.class) {
			Lead =(Warehouse)lead;
		}
		else if(lead!=null && lead.getClass()==Store.class) {
			Lead =(Store)lead;
			
		}
		else {Lead=null;}
		this.LeadID=leadID;
		this.LeadName=leadName;
		System.out.println("Generated Inventory!!!!");
		System.out.println("Lead"+Lead.getClass());
		System.out.println("ID:"+LeadID);
		System.out.println("Name:"+LeadName);
		CategoryList=new ArrayList<Category>();
	}
	
	
	//-------------------------------------------Category Functions-------------------------------------------------
	
	
	
	public void Add_Category(String Category_Name) {
		String new_cat_ID=this.Generate_New_Category_ID();
		Category new_category=new Category(this,Category_Name,new_cat_ID,this.LeadName);
		System.out.println("Name:"+new_category.getCategory_Name());
		System.out.println("Category ID:"+new_category.getCategory_ID());
		System.out.println("Path:"+new_category.getCategory_Path());
		this.CategoryList.add(new_category);
	}
	public String Generate_New_Category_ID() {
		String new_ID=LeadID+"-c"+Number_of_Categories;
		Number_of_Categories++;
		return new_ID;
	}
	public void update_category_name(String Category_name,String new_name) {
		//The categories in the field in Subcategory Class are they changing?
		//Test it?
		
		this.Search_Category(Category_name).setCategory_Name(new_name);
	}
	public void delete_category(String category_name) {
		int t=0;
		for(int i=0;i<CategoryList.size();i++) {
			if(CategoryList.get(i).getCategory_Name().equals(category_name)) {
				t=i;
				System.out.println("Found the Subcategory to Delete");
				break;
			}
		}
		this.delete_all_subcategory(CategoryList.get(t));
		CategoryList.remove(t);
	}
	
	
	//--------------------------------------Subcategory Functions beginning Here --------------------------------------------
	 
	
	public void add_subcategory(String subcategory_name,String path) {
		String[] patharray=path.split(">");
		String catname=patharray[1];
		Subcategory s=this.Search_Category(catname).Add_Subcategory(subcategory_name);
		System.out.println("Name:"+s.getSubcategory_Name());
		System.out.println("SubCategory ID:"+s.getSubcategory_ID());
		System.out.println("Path:"+s.getSubcategory_Path());
		this.SubcategoryPathMap.put(s.getSubcategory_Name(),s.getSubcategory_Path());
	}
	
	//Invoked when a category has to be deleted
	public void delete_all_subcategory(Category cat) {//Deletes all Subcategories of a category
		System.out.println("Deleting all Subcategories of "+cat.getCategory_Name()+"...............");
		ArrayList<String> s=new ArrayList<String>();	
		for(int i=0;i<cat.getSubcategory_List().size();i++) {
			s.add(cat.getSubcategory_List().get(i).getSubcategory_Name());
			this.delete_all_product(cat.getSubcategory_List().get(i));
		}
		for(int i=0;i<s.size();i++){//Removing from SubcategoryPathList
			this.SubcategoryPathMap.remove(s.get(i));
		}
		cat.getSubcategory_List().clear();
		}
		
	public void delete_subcategory(String subcategory_name) {
			String path=this.SubcategoryPathMap.get(subcategory_name);
			String[] c=path.split(">");
			String catname=c[1];
			this.Search_Category(catname).delete_subcategory(subcategory_name);
			this.SubcategoryPathMap.remove(subcategory_name);
	}
	
	public void update_subcategory_name(String subcategory_name,String new_name) {
		//Would it update the fields in the Category class and Product Objects which have the Subcategory as it's name?  
		//Test it out?
		System.out.println("Retrieving Subcategory Path from HashMap....");
		String path=this.SubcategoryPathMap.get(subcategory_name);
		System.out.println("Changing Subcategory Name ");
		this.Search_Subcategory(subcategory_name).setSubcategory_Name(new_name);
		System.out.println("Removing previous name from hashmap....");
		this.SubcategoryPathMap.remove(subcategory_name);
		System.out.println("Adding New Name and (old) path to hashmap......");
		this.SubcategoryPathMap.put(new_name, path);
	}
	
	//-----------------------------Product Functions beginning Here---------------------------------------------- 
	
	//For add ,update standard standard notations are 
	//String Product_name,String path,int quantity,double price,double Fixed_Price,double Carry_Cost,int Demand,String Descp
	
	
	public void add_new_product(String Product_name,String path,int quantity,double price,double Fixed_Price,double Carry_Cost,int Demand,String Descp) {
		String[] patharray=path.split(">");
		String catname=patharray[1];
		String subcatname=patharray[2];
		Subcategory s=this.Search_Subcategory(subcatname);
		Product p=s.Add_Product(Product_name,quantity, price,Fixed_Price,Carry_Cost,Demand,Descp);
		this.ProductPathMap.put(p.getProd_Name(),p.getProd_Path());
	}
	public void Update_Product(String Product_name,String new_name,int quantity,double new_price,double new_fixed,double new_carry,int new_demand,String Descp) {
		this.Search_Product(Product_name).setPrice(new_price);
		this.Search_Product(Product_name).setFixed_Price(new_fixed);
		this.Search_Product(Product_name).setCarry_Cost(new_carry);
		this.Search_Product(Product_name).setQuantity(quantity);
		this.Search_Product(Product_name).setDemand(new_demand);
		this.Search_Product(Product_name).setDescription(Descp);
		String path=this.ProductPathMap.get(Product_name);
		this.ProductPathMap.put(new_name, path);
		this.ProductPathMap.remove(Product_name);
		this.Search_Product(Product_name).setProd_Name(new_name);
	}
	
	
	public void delete_product(String Product_name) {
		String prod_path=this.ProductPathMap.get(Product_name);
		System.out.println("Path of Product to be deleted :"+prod_path);
		String[] s=prod_path.split(">");
		String catname=s[1];
		String subcatname=s[2];
		this.Search_Subcategory(subcatname).delete_product(Product_name);
		this.ProductPathMap.remove(Product_name);
	}
	
	
	//Invoked when a subcategory has to be deleted 
		public void delete_all_product(Subcategory subcat) {//Deletes all Products of a SubCategories of a subcategory
			System.out.println("Deleting All Products from Subcategory "+subcat.getSubcategory_Name()+"...........");
			ArrayList<String> s=new ArrayList<String>();
			for(int i=0;i<subcat.getProduct_List().size();i++) {
				s.add(subcat.getProduct_List().get(i).getProd_Name());
			}
			for(int i=0;i<s.size();i++) {
				System.out.println("Deleting "+s.get(i)+"...");
				ProductPathMap.remove(s.get(i));
				System.out.println("Removing "+s.get(i)+" from ProductPathMap");
				
			}
			subcat.getProduct_List().clear();
			System.out.println("Cleared Subcategory "+subcat.getSubcategory_Name()+"'s Products List");
		}
	
	
		
	//--------------------------------------All Search Functions Search by Name and Return The Object----------------------------------
	public Category Search_Category(String Category_name) {//Searches and returns Category by Name
		int cat_index=0;
		for(int i=0;i<CategoryList.size();i++) {
			if(CategoryList.get(i).getCategory_Name().equals(Category_name)) {
				cat_index=i;
				break;
			}
		}
		return this.CategoryList.get(cat_index);
	}
	public Subcategory Search_Subcategory(String Subcategory_name) {//Searches and return Subcategory by Name
		String path=this.SubcategoryPathMap.get(Subcategory_name);
		System.out.println("Full Path of Subcategrory:"+path);
		String[] patharray=path.split(">");
		String catname=patharray[1];
		int cat_index=0;
		int check=0;
		int sub_cat_index=0;
		for(int i=0;i<CategoryList.size();i++) {
			if(CategoryList.get(i).getCategory_Name().equals(catname)) {
				cat_index=i;
				check=1;
				System.out.println("Found the Category ");
				break;
			}
		}
		if(check==0) {
			System.out.println("Invalid Category");
			System.out.println("Invalid Path");
			return null;
		}
		System.out.println(CategoryList.get(cat_index).getSubcategory_List().size());
		for(int j=0;j<CategoryList.get(cat_index).getSubcategory_List().size();j++) {
			System.out.println("h"+CategoryList.get(cat_index).getSubcategory_List().get(j).getSubcategory_Name());
			if(CategoryList.get(cat_index).getSubcategory_List().get(j).getSubcategory_Name().equals(Subcategory_name)) {
				
				sub_cat_index=j;
				check=-1;
				System.out.println("Found the Subcategory");
				break;
			}
		}
		if(check!=-1) {
			System.out.println("Invalid Subcategory");
			System.out.println("Invalid path2");
			return null;
		}
		return CategoryList.get(cat_index).getSubcategory_List().get(sub_cat_index);
	}
	
	
	
	public Product Search_Product(String Product_name) {
		String path=ProductPathMap.get(Product_name);
		String[] patharray=path.split(">");
		String catname=patharray[1];
		String subcatname=patharray[2];
		Subcategory s=this.Search_Subcategory(subcatname);
		int y=0;
		int ch=0;
		for(int k=0;k<s.getProduct_List().size();k++) {
			if(s.getProduct_List().get(k).getProd_Name().equals(Product_name)) {
				y=k;
				ch=1;
				break;
			}
		}
		if(ch==0) {
			System.out.println("Invalid path");
			return null;
		}
		return s.getProduct_List().get(y);
	}


	public void print_inventory() {
		System.out.println("Number of Categories:"+this.CategoryList.size());
		for(int i=0;i<this.CategoryList.size();i++) {
			this.CategoryList.get(i).print_details();
		}
		
	}
	
	
	
	
	
	
	
	
	/**
	 * @return the categoryList
	 */
	public ArrayList<Category> getCategoryList() {
		return CategoryList;
	}


	/**
	 * @param categoryList the categoryList to set
	 */
	public void setCategoryList(ArrayList<Category> categoryList) {
		CategoryList = categoryList;
	}


	/**
	 * @return the productPathMap
	 */
	public HashMap<String, String> getProductPathMap() {
		return ProductPathMap;
	}


	/**
	 * @param productPathMap the productPathMap to set
	 */
	public void setProductPathMap(HashMap<String, String> productPathMap) {
		ProductPathMap = productPathMap;
	}


	/**
	 * @return the subcategoryPathMap
	 */
	public HashMap<String, String> getSubcategoryPathMap() {
		return SubcategoryPathMap;
	}


	/**
	 * @param subcategoryPathMap the subcategoryPathMap to set
	 */
	public void setSubcategoryPathMap(HashMap<String, String> subcategoryPathMap) {
		SubcategoryPathMap = subcategoryPathMap;
	}


	/**
	 * @return the number_of_Categories
	 */
	public int getNumber_of_Categories() {
		return Number_of_Categories;
	}


	/**
	 * @param number_of_Categories the number_of_Categories to set
	 */
	public void setNumber_of_Categories(int number_of_Categories) {
		Number_of_Categories = number_of_Categories;
	}


	/**
	 * @return the lead
	 */
	public Object getLead() {
		return Lead;
	}


	/**
	 * @return the leadID
	 */
	public String getLeadID() {
		return LeadID;
	}


	/**
	 * @return the leadName
	 */
	public String getLeadName() {
		return LeadName;
	}

	

	
	
	
}
