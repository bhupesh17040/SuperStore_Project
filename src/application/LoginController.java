package application;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
public class LoginController {
	private int checkusertype;
	private Database dbt;
	@FXML private ImageView MainImage;
	@FXML private Button LoginButton;
	@FXML private Button BacktoMainMenu;
	@FXML private TextField UserIDEntered;
	@FXML private TextField PasswordEntered;
	@FXML private Button ForgotPassword;
	@FXML private Label StatusLabel;
	public void receive(int check,Database dbt) {
		this.UserIDEntered.setText("");
		this.PasswordEntered.setText("");
		this.checkusertype=check;
		System.out.println("W="+this.UserIDEntered.getText());
		System.out.println("P="+this.PasswordEntered.getText());
		System.out.println("Check"+check);
		this.dbt=dbt;
	}
	public void Login(ActionEvent event) {
		System.out.println("W1="+this.UserIDEntered.getText());
		System.out.println("P1="+this.PasswordEntered.getText());
		if(this.PasswordEntered.getText().equals("") && this.UserIDEntered.getText().equals("")) {
			this.StatusLabel.setText("Your UserID and Password cannot be Empty");
		}
		else if(this.UserIDEntered.getText().equals("")) {
			this.StatusLabel.setText("Your UserID cannot be Empty");
		}
		else if(this.PasswordEntered.getText().equals("")){
			this.StatusLabel.setText("Your Password cannot be Empty");
		}
		else {
		
		if(this.checkusertype==1) {
			String u=dbt.getSuperuser().getSuperuserID();
			String p=dbt.getSuperuser().getPassword();
			if(this.PasswordEntered.getText().equals(p) && this.PasswordEntered.getText().equals(u))if(this.PasswordEntered.getText().equals("") && this.UserIDEntered.equals("")) {
				this.StatusLabel.setText("Your UserID and Password canot be Empty");
			}
		}
		else if(this.checkusertype==2) {
			
		}
		else if(this.checkusertype==3) {
			
		}
		
		}
	}
	public void back(ActionEvent event) {
		
	}
	
	
}
