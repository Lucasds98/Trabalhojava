package pessoafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


	public class Main extends Application{

		@Override
		public void start(Stage primaryStage) throws IOException {

			Pane root = FXMLLoader.load(getClass().getResource("FXMLPESSOA.fxml"));
			
			Scene scene = new Scene(root, 1000, 1000);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}