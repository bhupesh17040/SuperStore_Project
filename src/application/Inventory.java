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
	}
	//Category Functions
	public void Add_Category(String Category_Name) {
		String new_cat_ID=this.Generate_New_Category_ID();
		Category new_category=new Category(this,Category_Name,new_cat_ID,this.LeadName);
		this.CategoryList.add(new_category);
	}
	public String Generate_New_Category_ID() {
		String new_ID=LeadID+"-c"+Number_of_Categories;
		Number_of_Categories++;
		return new_ID;
	}
	public void update_category_name(String Category_name,String new_name) {
		this.Search_Category(Category_name).setCategory_Name(new_name);
	}
	public void delete_category(String category_name) {
		int t=0;
		for(int i=0;i<CategoryList.size();i++) {
			if(CategoryList.get(i).getCategory_Name().equals(category_name)) {
				t=i;
				break;
			}
		}
		this.delete_all_subactegory(CategoryList.get(t));
		CategoryList.remove(t);
	}
	
	//Subactegory Functions
	public void add_subcategory(String subcategory_name,String path) {
		String[] patharray=path.split(">");
		String catname=patharray[1];
		Subcategory s=this.Search_Category(catname).Add_Subcategory(subcategory_name);
		this.SubcategoryPathMap.put(s.getSubcategory_Name(),s.getSubcategory_Path());
	}
	//Invoked when a category has to be deleted
	public void delete_all_subactegory(Category cat) {//Deletes all Subcategories of a category
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
		this.Search_Subcategory(subcategory_name).setSubcategory_Name(new_name);
	}
	
	
	public void add_new_product(String Product_name,String path,double price) {
		String[] patharray=path.split(">");
		String catname=patharray[1];
		String subcatname=patharray[2];
		Subcategory s=this.Search_Subcategory(subcatname);
		Product p=s.Add_Product(Product_name, price);
		this.ProductPathMap.put(p.getProd_Name(),p.getProd_Path());
	}
	
	
		public void Update_Product(String Product_name,String new_name,int quantity,double new_price,Double new_fixed,int new_demand,double new_carry) {
			this.Search_Product(Product_name).setProd_Name(new_name);
			this.Search_Product(Product_name).setPrice(new_price);
			this.Search_Product(Product_name).setFixed_Price(new_fixed);
			this.Search_Product(Product_name).setCarry_Cost(new_carry);
			this.Search_Product(Product_name).setQuantity(quantity);
			this.Search_Product(Product_name).setDemand(new_demand);
		}
	
	
	public void delete_product(String Product_name) {
		String prod_path=this.ProductPathMap.get(Product_name);
		String[] s=prod_path.split(">");
		String catname=s[1];
		String subcatname=s[2];
		this.Search_Subcategory(subcatname).delete_product(Product_name);
		this.ProductPathMap.remove(Product_name);
	}
	//Invoked when a subcategory has to be deleted 
		public void delete_all_product(Subcategory subcat) {//Deletes all Products of a SubCategories of a subcategory
			ArrayList<String> s=new ArrayList<String>();
			for(int i=0;i<subcat.getProduct_List().size();i++) {
				s.add(subcat.getProduct_List().get(i).getProd_Name());
			}
			for(int i=0;i<s.size();i++) {
				ProductPathMap.remove(s.get(i));
			}
			subcat.getProduct_List().clear();
		}
	
	//All Search Functions
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
		String[] patharray=path.split(">");
		String catname=patharray[1];
		int cat_index=0;
		int check=0;
		int sub_cat_index=0;
		for(int i=0;i<CategoryList.size();i++) {
			if(CategoryList.get(i).getCategory_Name().equals(catname)) {
				cat_index=i;
				check=1;
				break;
			}
		}
		if(check==0) {
			System.out.println("Invalid path");
			return null;
		}
		for(int j=0;j>CategoryList.get(cat_index).getSubcategory_List().size();j++) {
			if(CategoryList.get(cat_index).getSubcategory_List().get(j).getSubcategory_Name().equals(Subcategory_name)) {
				sub_cat_index=j;
				check=-1;
				break;
			}
		}
		if(check!=-1) {
			System.out.println("Invalid path");
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
			if(s.getProduct_List().get(k).equals(Product_name)) {
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

	

	
	
	
}
