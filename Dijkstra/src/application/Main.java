package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Rmap.fxml"));
	        AnchorPane pane = loader.load();
	        Scene scene = new Scene(pane);
	        primaryStage.setTitle("Ramallah Map");
	        primaryStage.setScene(scene);
	        primaryStage.show();
			
//	        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent ->{
//	            System.out.println(mouseEvent.getX()+","+mouseEvent.getY());
//	        });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void main(String[] args) {

		launch(args);
	}
	
	
}
