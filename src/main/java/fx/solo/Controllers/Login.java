package fx.solo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import static fx.solo.Uses.Uses.changeScene;
import java.io.IOException;



public class Login {
    @FXML
    private Label loginEmail;
    @FXML
    private PasswordField loginPassword;

//    method to verify email
//    protected void verifyLoginEmail{
//
//    }

//    method to verify password
//    protected void verifyPassword{
//
//    }



    @FXML
    public void redirectToSignup(ActionEvent event) throws IOException{
        changeScene(event, "/fx/solo/fxml/signup.fxml", "Signup");
    }
}