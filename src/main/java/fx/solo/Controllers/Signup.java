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
    protected void initialize() {
        final String[] faculty = {"BCS", "BHM", "BBA", "BIHM", "MCS", "MBA"};
        signupFaculty.getItems().addAll(faculty);  //adding the dropdown
        final String[] gender = {"Male", "Female", "Others"};
        signupGender.getItems().addAll(gender);
        signupErrorLabel.setText("");
        addInputListeners();
    }

    protected void addInputListeners() {
        signupFullName.textProperty().addListener((_) -> clearErrorLabels());
        signupEmail.textProperty().addListener((_) -> clearErrorLabels());
        signupPhoneNumber.textProperty().addListener((_) -> clearErrorLabels());
    }

    protected void clearErrorLabels() {
        signupErrorLabel.setText("");
    }

    @FXML
    protected void signupBtnClicked() {
        String fullName = signupFullName.getText();
        String email = signupEmail.getText();
        String faculty = signupFaculty.getValue();
        String gender = signupGender.getValue();
        String phoneNumber = signupPhoneNumber.getText();
        String password = signupPassword.getText();
        String cPassword = signupConformPassword.getText();
        
        System.out.println(faculty); //if faculty field is empty, it prints 'null' to the console
        System.out.println(email);  //even if i put email blank, it prints nothing.

//        here isEmpty() did not work for choiceboxes
        if (fullName.isEmpty() || email.isEmpty() || faculty == null || gender == null || phoneNumber.isEmpty() || password.isEmpty() || cPassword.isEmpty()) {
            error(signupErrorLabel, "Field/s is empty", true);
        }
//        when all fields are filled then this block is executed to verify all fields.
        else {
            validateFullName();
            validateEmail();
        }
    }

    private void validateFullName() {
        String fullName = signupFullName.getText();

//            a. length must be greater than 5
        int validateLength = fullName.length();
        if (validateLength < 5) {
            error(signupErrorLabel, "Full Name length not acceptable !", true);
        }
//            b. There cannot be space at the 0th or last index in name
        else if (fullName.charAt(0) == ' ' || fullName.charAt(validateLength - 1) == ' ') {
            error(signupErrorLabel, "Invalid full name", true);
        }
//            c. There should be at least a space in the full name
        int numOfSpacesInName = 0;
        for (int i = 1; i <= validateLength - 2; i++) {
            if (fullName.charAt(i) == ' ') {
                numOfSpacesInName++;
            }
        }
        if (numOfSpacesInName == 0) {
            error(signupErrorLabel, "Provide a valid full name", true);
        }
    }

    private void validateEmail(){

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
