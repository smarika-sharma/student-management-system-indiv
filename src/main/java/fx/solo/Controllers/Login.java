package fx.solo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import static fx.solo.Uses.Uses.changeScene;
import java.io.IOException;

public class Login {
    @FXML
    private TextField loginEmail;
    @FXML
    private PasswordField loginPassword;

    @FXML
    public void redirectToSignup(ActionEvent event) throws IOException{
        changeScene(event, "/fx/solo/fxml/signup.fxml", "Signup");
    }

}