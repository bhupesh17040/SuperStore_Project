package application;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class StoreCategoryListController implements Initializable{
	
	@FXML private ListView<String> Categorylist;
	@FXML private Button AddCategoryButton;
	@FXML private Button DeleteCataegoryButton;
	@FXML private Button UpdateCategoryName;
	@FXML private Button SortCategoryListButton;
	@FXML private Button BrowseCategoryButton;
	@FXML private TextField SearchCategoryBox;
	ObservableList<String> list=FXCollections.observableArrayList("Electronics","Housing and LifeStyle","Clothing");
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Categorylist.setItems(list);
	}
	
}
