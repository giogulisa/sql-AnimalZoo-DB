package controller;
import Service.AuthService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class MainController {
    public TextField main_username;
    public PasswordField main_password;
    public Label main_LoginFailed;

    private static final Logger log = Logger.getLogger(MainController.class);

    public void main_clicked(ActionEvent actionEvent) {
//        System.out.println("username : " + main_username.getText());
//        System.out.println("password : " + main_password.getText());

        try {
            // თუ წარმატებული ავტორიზაციაა მაშინ ვხსნით ახალ ველს
            if (AuthService.Authorisation(main_username.getText(), main_password.getText())) {
                log.info("სისტემაში შევიდა მომხმარებელი " + main_username.getText());
                // ახალი ფორმის გახსნა
                System.out.println("vcdilob axalis agxsnas");
                Stage newStage = new Stage();
                Parent root1 = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
                newStage.setTitle("Add Animals");
                newStage.getIcons().add(new Image("view/zoo.png"));
                newStage.setScene(new Scene(root1, 370, 256));
                newStage.show();
                // აქამდე რა ფორმაც იყო იმ ფორმის დახურვა
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
            }
            else {
                main_LoginFailed.setText("არასწორია, სცადეთ თავიდან");
                log.error("სისტემაში არასწორი შესვლა user: " + main_username.getText() + " password " + main_password.getText());
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
