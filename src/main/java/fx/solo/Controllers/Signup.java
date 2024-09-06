package fx.solo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

import static fx.solo.Uses.Uses.changeScene;

public class Signup {
@FXML
private Label signupFullName;
@FXML
private Label signupEmail;
@FXML
private Label signupPhoneNumber;
@FXML
private PasswordField signupPassword;
@FXML
private PasswordField signupConformPassword;
@FXML
private Label signupErrorLabel;

String fullname= signupFullName.getText();
String email= signupEmail.getText();
String phonenumber= signupPhoneNumber.getText();
String password= signupPassword.getText();
String cpassword= signupConformPassword.getText();

protected void emptyErrorLabel(){
    signupErrorLabel.setText("");
    }

protected void verifyFullName(){

    }

    @FXML
    public void redirectToLogin(ActionEvent event) throws IOException {
    changeScene(event,"/fx/solo/fxml/login.fxml", "Login" );
    }
}
