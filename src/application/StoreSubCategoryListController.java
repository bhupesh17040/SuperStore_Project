package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class StoreSubCategoryListController implements Initializable{
	@FXML private Button BrowseSubcategory;
	@FXML private Button AddSubcategory;
    @FXML private Button DeleteSubcategory;
    @FXML private Button UpdateSubcategory;
    @FXML private Button backbutton;
    @FXML private Button SortSubcategoryList;
    @FXML private ListView<String> SubcategoryList;
    @FXML private TextField SearchSubcategoryBox;
    @FXML private ImageView MainImage;
    @FXML private Label CurrentLocationLabel;
    ObservableList<String> list=FXCollections.observableArrayList("Mobile Phones","HeadPhones","TV");
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		SubcategoryList.setItems(list);
	}

}
