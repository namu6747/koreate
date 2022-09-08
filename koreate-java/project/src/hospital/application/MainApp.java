package hospital.application;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		Font.loadFont(getClass().getResourceAsStream("../view/css/nelnalizzychae2020.ttf"),14);
		Scene scene = isServer() ? new Scene(new Admin_Root(primaryStage)):
									new Scene(new User_Root(primaryStage));
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("영남병원");
		primaryStage.setResizable(false);
		primaryStage.show();

	}
		
	private boolean isServer() {
		String localHost = null;
		try {
			localHost = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return !Objects.equals(localHost, "192.168.1.178");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
