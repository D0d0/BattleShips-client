package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Game game = new Game();
    @FXML
    private Button versionButton;
    @FXML
    private Button createGameButton;
    @FXML
    private Button joinGameButton;
    @FXML
    private TextField textInput;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert versionButton != null : "fx:id=\"versionButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert createGameButton != null : "fx:id=\"createGameButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert joinGameButton != null : "fx:id=\"joinGameButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert textInput != null : "fx:id=\"textInput\" was not injected: check your FXML file 'sample.fxml'.";

        versionButton.setOnAction(event -> {
            game.getVersion();
        });
        createGameButton.setOnAction(event -> {
            game.createGame();
        });
        joinGameButton.setOnAction(event -> {
            game.joinGame(textInput.getText());
        });
    }
}
