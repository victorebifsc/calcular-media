package application;
	
import com.ifsc.tds.controller.ViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//loader fxml
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ifsc/tds/view/View.fxml"));
			Parent fxmlArchive = loader.load();
			
			//set css
			fxmlArchive.getStylesheets().add(getClass().getResource("/com/ifsc/tds/css/application.css").toExternalForm());
			
			//set fxml to scene
			Scene scene = new Scene(fxmlArchive);
			
			//stage configs
			primaryStage.setTitle("Calcular média");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			
			//controller
			ViewController viewController = loader.getController();
			
			//set close request
			primaryStage.setOnCloseRequest(e->{
				if (viewController.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});
			
			//show window
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
