package controller;

import Service.AnimalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Animal;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public TextField reg_Name;
    public TextField reg_Type;
    public ComboBox reg_Gender;
    public TextField reg_Age;

    public void reg_button(ActionEvent actionEvent) {
        Animal animal = new Animal();
        animal.setName(reg_Name.getText());
        animal.setType(reg_Type.getText());
        animal.setGender(reg_Gender.getSelectionModel().getSelectedItem().toString());
        animal.setage(reg_Age.getText());
        AnimalService.addAnimal(animal);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> gender = FXCollections.observableArrayList("მამრობითი", "მდედრობითი");
        reg_Gender.setItems(gender);
    }
}
