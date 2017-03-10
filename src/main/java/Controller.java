import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {


    @FXML
    private TextArea text = new TextArea();
    @FXML
    private Button open;
    public static File file;
    private Parent parent;
    private Scene scene;
    private Stage stage;
    private DialogTxt txt;

   /* public Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/sample.fxml"));
        fxmlLoader.setController(this);
        try {
            parent = (Parent) fxmlLoader.load();
            scene = new Scene(parent, 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void launchController(Stage stage) {
        this.stage = stage;
        stage.setTitle("User Login");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.hide();
        stage.show();
    }

    @FXML
    public void createFile(ActionEvent actionEvent) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Wingfly\\Desktop\\forsend.txt"));
            writer.write(text.getText());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chooseFile(String title, Button button) {

        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("JSON file (*.json)", "*.json");
        chooser.getExtensionFilters().add(filter);
        chooser.setTitle(title);
        file = chooser.showOpenDialog(button.getScene().getWindow());
        if (file != null) {
            try {
                FileWriter writer1 = new FileWriter("C:\\Users\\Wingfly\\Desktop\\justadded.txt");
                writer1.write(readFile(file));
                writer1.flush();
                System.out.println(readFile(file));
                Label label = new Label();
                label.setPrefSize(413, 212);
                label.setLayoutX(325.0);
                label.setLayoutY(27.0);
                label.setAlignment(Pos.TOP_LEFT);
                label.setText("hello");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("hello");



            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private String readFile(File file) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            int text;
            while ((text = reader.read()) != -1) {
                builder.append((char) text);
            }
        } catch (Exception e) {
            alert.setTitle("exception catched");
            alert.setContentText(String.valueOf(e));
            alert.setHeaderText("Error");
            alert.show();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                alert.setTitle("exception catched");
                alert.setHeaderText("Error");
                alert.setContentText(String.valueOf(e));
                alert.show();
            }
        }
        return builder.toString();
    }


    public void open(ActionEvent actionEvent) {
        chooseFile("Choose a  file", open);
    }


}
