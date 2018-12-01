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
		wa.add_category("Electronics");
		sa.add_category("Electronics");
		wa.add_category("Clothes");
		sa.add_category("Clothes");
		wa.add_subcategory("TV", "warehouse1>Electronics");
		sa.add_subcategory("TV", "store1>Electronics");
		wa.add_subcategory("Electronics", "warehouse1>Electronics");
		sa.add_subcategory("TV", "store1>Electronics");
		
		wa.add_new_product("Sony_10", "warehouse1>Electronics>TV", 10, 100, 20, 10, 23, "Idiot Box");
		sa.add_new_product("Sony_10", "warehouse1>Electronics>TV", 10, 100, 20, 10, 23, "Idiot Box");
		sa.delete_subcategory("TV");
		
		//sa.add_subcategory("TV", );
	}

}
