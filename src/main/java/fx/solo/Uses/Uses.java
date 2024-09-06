package fx.solo.Uses;

import fx.solo.HelloApplication;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;

import java.io.IOException;

public class Uses {

    //for obtaining the current stage or window so that we can change the scene of the current stage.
public static Stage getCurrentStage(ActionEvent event){
    Node node= (Node)event.getSource(); //typecasting into Node type as the event.getSource() returns object type
    Scene scene= node.getScene();// getScene returns the scene location of where the event is located
    Stage stage= (Stage) scene.getWindow(); //getWindow() returns the window where the scene is loaded
    return stage;
}

    public static FXMLLoader changeScene(ActionEvent event , String sceneName, String scenneTitle){
    Stage stage= getCurrentStage(event); //get the current stage
    FXMLLoader fxmlLoader= new FXMLLoader(HelloApplication.class.getResource(sceneName));  //create a new object
        Parent root= stage.getScene().getRoot();

        FadeTransition fadeOut= new FadeTransition(Duration.millis(500), root);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.setOnFinished(e ->{
            try {
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.setTitle(scenneTitle);
            }catch (IOException ex){
                ex.getMessage();
            }
                }
                );
        fadeOut.play();
        return fxmlLoader;
    }


}
