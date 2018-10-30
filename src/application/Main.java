package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.*;
import javafx.stage.*;
import javafx.scene.*;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {//Opens the Opening Page of our Document
		try {
			Parent root=FXMLLoader.load(getClass().getResource("/CreateSubCategory.fxml"));
			Scene scene=new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Welcome to SuperStore!!!");
			//primaryStage.setMaximized(true);
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
