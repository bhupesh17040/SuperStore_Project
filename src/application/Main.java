package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;
import java.util.*;import java.lang.*;import java.awt.*;
public class Main extends Application{
	private Database dbt=new Database();
	public void start(Stage primaryStage) {//Opens the Opening Page of our Document
		try {
			FXMLLoader loader =new FXMLLoader();
			loader.setLocation(getClass().getResource("/OpeningPage.fxml"));
			Parent root=loader.load();
			OpeningPageController controller=loader.getController();
			controller.receive(this.dbt);
			Scene scene=new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome to SuperStore!!!");
			primaryStage.show();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
