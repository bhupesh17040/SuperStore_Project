package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class OpeningPageController {
	@FXML private RadioButton checkusertype1;//SuperUser
    @FXML private RadioButton checkusertype2;//WarehouseAdmin
    @FXML private RadioButton checkusertype3;//StoreAdmin
    @FXML private RadioButton checkusertype4;//GuestUser
    @FXML private Button exitbutton;// Exit/Quit Button
    @FXML private Button nextbutton;// NextButton
    @FXML private ImageView MainImage;//Main Image
    @FXML private Label checktype;
    private int pass_to_next_window=0;
    private Database dbt;
    public void receive(Database dbt) {
    	this.dbt=dbt;
    }
    public void selectusertype(ActionEvent event){
    	/*This function checks the which RadioButton has been selected
    	 * and  
    	 * */
    	String c="Hi ,Are you sure you are a ";
    	String check_user_type=c;
    	if(this.checkusertype1.isSelected()) {//SuperUser selected
    		check_user_type=check_user_type+this.checkusertype1.getText()+"?"+"\n";
    		this.pass_to_next_window=1;
    	}
    	else if(this.checkusertype2.isSelected()) {//Warehouse Admin Selectee
    		check_user_type=check_user_type+this.checkusertype2.getText()+"?"+"\n";
    		this.pass_to_next_window=2;
    	}
    	else if(this.checkusertype3.isSelected()) {//Store Admin Selected
    		check_user_type=check_user_type+this.checkusertype3.getText()+"?"+"\n";
    		this.pass_to_next_window=3;
    	}
    	else if(this.checkusertype4.isSelected()) {//Guest User Selected
    		check_user_type=check_user_type+this.checkusertype4.getText()+"?"+"\n";
    		this.pass_to_next_window=4;
    	}
    checktype.setText(check_user_type);
    }
    
    public void next(ActionEvent event) throws IOException{
    	if(this.pass_to_next_window==1 || this.pass_to_next_window==2 || this.pass_to_next_window==3) {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("/Login.fxml"));
			Parent root=loader.load();
			LoginController controller=loader.getController();
			controller.receive(this.pass_to_next_window,this.dbt);
			Scene scene=new Scene(root);
			Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Login");
			window.show();
		}
    	else if(this.pass_to_next_window==4) {
    		FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("/CreateEndUser.fxml"));
			Parent root=loader.load();
			//LoginController controller=loader.getController();
			//controller.receive(this.pass_to_next_window);
			Scene scene=new Scene(root);
			Stage window=(Stage)((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.setTitle("Customer Credentials");
			window.show();
    	}
    	else {
    		this.checktype.setText("Please select a type of user to proceed");
    	}
		
		
    }
}
