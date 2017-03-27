package br.com.dom.modernflatlayout.controller;

import eu.hansolo.enzo.roundlcdclock.RoundLcdClock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by DOM on 26/03/2017.
 */
public class RootController implements Initializable {
    @FXML
    private RoundLcdClock clock;
    @FXML
    private BorderPane contentPane;
    @FXML
    private AnchorPane base;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    private void init() {
        clock.setColor(Color.WHITE);
        clock.setOpacity(0.6);

        contentPane.prefWidthProperty().bind(base.widthProperty());
        contentPane.prefHeightProperty().bind(base.heightProperty());
    }

    @FXML
    void close() {
        System.exit(0);
    }

    @FXML
    void expand() {
        if (((Stage) clock.getParent().getScene().getWindow()).isMaximized())
            ((Stage) clock.getParent().getScene().getWindow()).setMaximized(false);
        else ((Stage) clock.getParent().getScene().getWindow()).setMaximized(true);
    }

    @FXML
    void minimize() {
        ((Stage) clock.getParent().getScene().getWindow()).setIconified(true);
    }
}
