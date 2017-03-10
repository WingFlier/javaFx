import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


  /*  public Controller() {
        FXMLLoader fxmlLoader = null;

        try {
            parent =   fxmlLoader.load(getClass().getResource("sample.fxml"));
            scene = new Scene(parent, 300 , 275 );
            fxmlLoader.setController(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



  /*  public void launchController(Stage stage){
        this.stage = stage;

        stage.setScene(scene);
        stage.setTitle("title");
        stage.setResizable(false);
        stage.show();
    }*/

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
                // DialogTxt dialogTxt  = new DialogTxt();
                //dialogTxt.redirectDialog(stage, file);


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
