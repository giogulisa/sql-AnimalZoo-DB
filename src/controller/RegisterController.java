package controller;

import javafx.scene.control.Label;
import org.apache.log4j.Logger;
import Service.AnimalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Animal;
import util.SessionUtil;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public TextField reg_Name;
    public TextField reg_Type;
    public ComboBox reg_Gender;
    public TextField reg_Age;
    public Label reg_user1;

    private static final Logger log = Logger.getLogger(MainController.class);

    public void reg_Logout(ActionEvent actionEvent) throws IOException {
        log.info("მომხარებელი "+reg_user1 +" სიტემიდან გავიდა");
        Stage newStage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        newStage.setTitle("Zoo Manager");
        newStage.getIcons().add(new Image("view/zoo.png"));
        newStage.setScene(new Scene(root1, 256, 288));
        newStage.show();
        // აქამდე რა ფორმაც იყო იმ ფორმის დახურვა
        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
    }

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

        reg_user1.setText(SessionUtil.getCurrentUser().getUsername());
        ObservableList<String> gender = FXCollections.observableArrayList("მამრობითი", "მდედრობითი");
        reg_Gender.setItems(gender);
    }
}
