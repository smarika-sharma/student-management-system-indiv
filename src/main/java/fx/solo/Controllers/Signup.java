package fx.solo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import static fx.solo.Uses.Uses.changeScene;

public class Signup {
@FXML
private TextField signupFullName;
@FXML
private ChoiceBox<String> signupFaculty;
@FXML
private ChoiceBox<String> signupGender;
@FXML
private TextField signupEmail;
@FXML
private TextField signupPhoneNumber;
@FXML
private PasswordField signupPassword;
@FXML
private PasswordField signupConformPassword;
@FXML
private Label signupErrorLabel;

//String fullname= signupFullName.getText();
//String email= signupEmail.getText();
//String phonenumber= signupPhoneNumber.getText();
//String password= signupPassword.getText();
//String cpassword= signupConformPassword.getText();

    @FXML
    protected void initialize(){
        final String[] faculty= {"BCS", "BHM", "BBA", "BIHM", "MCS", "MBA"};
        signupFaculty.getItems().addAll(faculty);
        final String[] gender={"Male", "Female", "Others"};
        signupGender.getItems().addAll(gender);
        signupErrorLabel.setText("");
        addInputListeners();
    }

    protected void addInputListeners(){
        signupFullName.textProperty().addListener((_) -> clearErrorLabels());
        signupEmail.textProperty().addListener((_) -> clearErrorLabels());
        signupPhoneNumber.textProperty().addListener((_) -> clearErrorLabels());
    }

    protected void clearErrorLabels(){
        signupErrorLabel.setText("");
    }

//    protected void verifyFullName(){
//
//    }

    @FXML
    public void redirectToLogin(ActionEvent event) throws IOException {
    changeScene(event,"/fx/solo/fxml/login.fxml", "Login" );
    }

//    @FXML
//    private void onSignupButtonClicked(ActionEvent event){
//        String fullname= signupFullName.getText();
//        boolean validate=fullname.isEmpty();
//        if(validate){
//            error(signupErrorLabel, "Full Name Null", true);
//        }
//    }
}
