import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class DialogTxt {

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    public Label label_txt = new Label();

    public DialogTxt() {
        try {
            FXMLLoader loader = FXMLLoader.load(getClass().getResource("/resources/dialog.fxml"));
            loader.setController(this);
            root = (Parent) loader.load();
            scene = new Scene(root, 400, 300);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void redirectDialog(Stage stage, File file) {

    }
}
