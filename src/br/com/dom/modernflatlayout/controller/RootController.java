package br.com.dom.modernflatlayout.controller;

import br.com.dom.modernflatlayout.util.FXMLUtil;
import br.com.dom.modernflatlayout.view.animations.FadeInRightTransition;
import eu.hansolo.enzo.roundlcdclock.RoundLcdClock;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    @FXML
    private HBox topBar;

    double positionX, positionY;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    private void init() {

        clock.setColor(Color.WHITE);
        clock.setOpacity(0.6);

        contentPane.prefWidthProperty().bind(base.widthProperty());
        contentPane.prefHeightProperty().bind(base.heightProperty());
        contentPane.setCenter(FXMLUtil.getFxml("app_login"));

        topBar.setOnMousePressed(m -> {
            positionX = m.getSceneX();
            positionY = m.getSceneY();
        });

        topBar.setOnMouseDragged(m -> {
            topBar.getScene().getWindow().setX(m.getScreenX() - positionX);
            topBar.getScene().getWindow().setY(m.getScreenY() - positionY);
        });

    }


    @FXML
    private void actionButton(Event event) {
        String id = ((HBox) event.getSource()).getId();
        FadeInRightTransition f;        
        switch (id) {
            case "home":
                f = new FadeInRightTransition(contentPane);
                f.setOnFinished(a -> contentPane.setCenter(FXMLUtil.getFxml("app_login")));
                f.play();
                break;
            case "profile":
                f = new FadeInRightTransition(contentPane);
                f.setOnFinished(a -> contentPane.setCenter(FXMLUtil.getFxml("app_profile")));
                f.play();
                break;
        }
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
