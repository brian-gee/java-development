package sample;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {


    public TextField firstName;
    public TextField lastName;
    public TextField yearOfBirth;
    public TextField temporaryPassword;
    public Text printText;

    public void registerClick() {
        Validation v = new Validation();
        String errorMsg = "";
        errorMsg += v.isPresent(firstName.getText(),
                "First Name");
        errorMsg += v.isPresent(lastName.getText(),
                "Last Name");
        errorMsg += v.isPresent(yearOfBirth.getText(),
                "Year of Birth");

        if (errorMsg.isEmpty()) {
            String f = firstName.getText();
            String l = lastName.getText();
            String y = yearOfBirth.getText();
            temporaryPassword.setText(f + "*" + y);
            printText.setText("Welcome " + f + " " + l + "!");
        } else {
            printText.setText("Please enter first and last name and year of birth.");
            temporaryPassword.clear();
        }

    }

    public void exitClick() {
        System.exit(0);
    }





}