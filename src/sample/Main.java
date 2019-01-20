package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by misiek on 2017-04-11.
 */

public class Main extends Application {
  private Stage primaryStage;
  private AnchorPane layout;

  @Override
  public void start(Stage primaryStage) throws Exception{
    this.primaryStage=primaryStage;
    primaryStage.setTitle("Puzzle");
    primaryStage.getIcons().add(new Image("http://freedesignfile.com/upload/2013/05/pazzle_bckgr_03.jpg"));
    primaryStage.setResizable(false);
    initialize();
  }

  public void initialize() {
    try {
      FXMLLoader loader =new FXMLLoader();
      loader.setLocation(Main.class.getResource("Layout.fxml"));
      layout = (AnchorPane) loader.load();
      Scene scene = new Scene(layout);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
