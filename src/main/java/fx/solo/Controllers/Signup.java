package fx.solo.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static fx.solo.Uses.Uses.changeScene;
import static fx.solo.Uses.Uses.error;

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

    @FXML
    protected void initialize(){
        final String[] faculty= {"BCS", "BHM", "BBA", "BIHM", "MCS", "MBA"};
        signupFaculty.getItems().addAll(faculty);  //adding the dropdown
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

    @FXML
    protected void signupBtnClicked() {
    String fullName= signupFullName.getText();
    String email= signupEmail.getText();
    String faculty= signupFaculty.getValue();
    String gender= signupGender.getValue();
    String phoneNumber= signupPhoneNumber.getText();
    String password= signupPassword.getText();
    String cPassword= signupConformPassword.getText();

    if(fullName.isEmpty()|| email.isEmpty() || faculty.isEmpty()||gender.isEmpty()||phoneNumber.isEmpty()||password.isEmpty()||cPassword.isEmpty()){
        error(signupErrorLabel, "Field/s is empty", true);
    }
//    int validateLength= fullName.length();
//    if(validateLength<5){
//        error(signupErrorLabel, "Full Name length not acceptable !", true);
//    }
//    else {
//        if (fullName.charAt(0) == ' '|| fullName.charAt(-1) == ' ') {
//            error(signupErrorLabel, "Invalid name", true);
//        }
//        else {
////            there is at least a space in the full name.
//            for (int i = 0; i <= validateLength; i++) {
//            }
//        }
//    }
    }

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
