import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class DialogTxt {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    public Text label_txt;

   /* public DialogTxt() {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("fxml/dialog.fxml"));
        loader.setController(this);
        try {
            root = (Parent) loader.load();
            scene = new Scene(root, 400, 300);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    public void redirectDialog(Stage stage, String file) {
        stage.setTitle("text");
        stage.setScene(scene);
        label_txt.setText(String.valueOf(file));
        stage.hide();
        stage.show();


    }
}
