package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.ImageView;
public class StoreProductListController implements Initializable{
	@FXML private TreeTableView<?> ProductTable;
	@FXML private Button ProductInfo;
	@FXML private ImageView MainImage;
	@FXML private Button Back;
	@FXML private Label CurrentLocation;
	@FXML private TextField SearchProduct;
	@FXML private Button SortProductLlist;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
