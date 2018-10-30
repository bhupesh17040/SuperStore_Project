package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
public class OpeningPageController {
	@FXML private ToggleGroup Type_of_User_Group;
    @FXML private RadioButton checkusertype1;//SuperUser
    @FXML private RadioButton checkusertype2;//WarehouseAdmin
    @FXML private RadioButton checkusertype3;//StoreAdmin
    @FXML private RadioButton checkusertype4;//GuestUser
    @FXML private Button exitbutton;// Exit/Quit Button
    @FXML private Button nextbutton;// NextButton
    @FXML private ImageView MainImage;//Main Image
    public void selectRadioButton(ActionEvent event){
    	/*This function checks the which RadioButton has been selected
    	 * and moves to the corresponding window 
    	 * */
    }
}
