package application;

public class AdminInventoryTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Warehouse w=new Warehouse("warehouse1","w1");
		Store s=new Store("store1","s1");
		WarehouseAdmin wa=new WarehouseAdmin("WAdmin1","wa1","password",w);
		StoreAdmin sa=new StoreAdmin("SAdmin1","sa1","password",s);
		w.getStoresLinked().add(s);
		s.setLinkedWarehouse(w);
		System.out.println("-------------------------------------------------------------");
		wa.add_category("Electronics");
		sa.add_category("Electronics");
		
		wa.add_subcategory("TV", "warehouse1>Electronics");
		sa.add_subcategory("TV", "store1>Electronics");
		wa.add_subcategory("Headphones","warehouse1>Electronics");
		sa.add_subcategory("Headphones","store1>Electronics");
		wa.add_new_product("Bose_Headphones","warehouse1>Electronics>Headphones", 15,25000, 15, 10, 2,"Expensive");
		sa.add_new_product("Bose_Headphones","store1>Electrosnics>Headphones", 15,25000, 15, 10, 2,"Expensive");
		wa.add_new_product("Sony_10","warehouse1>Electronics>TV", 10, 100, 20, 10, 23, "Idiot Box");
		sa.add_new_product("Sony_10","store1>Electronics>TV", 10, 100, 20, 10, 23, "Idiot Box");
		
		
		
		wa.add_category("Clothes");
		sa.add_category("Clothes");
		wa.add_subcategory("Shirts","warehouse1>Clothes");
		wa.add_subcategory("T-Shirt","store1>Clothes");
		sa.add_subcategory("Shirts","warehouse1>Clothes");
		sa.add_subcategory("T-Shirt","store1>Clothes");
		System.out.println("---------------------------------------------------");
		wa.getWarehouseIncharge().getWInventory().print_inventory();
		//sa.getStoreIncharge().getsInventory().print_inventory();
		System.out.println("-----------------------------------------------------------");
		
		wa.delete_category("Electronics");
		
		wa.getWarehouseIncharge().getWInventory().print_inventory();
		//sa.getStoreIncharge().getsInventory().print_inventory();
		
		//sa.add_subcategory("TV", );
	}

}
